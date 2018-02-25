package com.xxscloud.api.core;

import com.google.gson.JsonSyntaxException;
import com.oracle.javafx.jmx.json.JSONException;
import com.xxscloud.core.JsonUtils;
import com.xxscloud.core.data.ResultDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import com.xxscloud.core.ToType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @author 李小双 2018.2.22
 */
@Service
public class ApiGatewayHand implements InitializingBean, ApplicationContextAware {

    private static final String METHOD = "method";
    private static final String PARAMETER = "parameter";
    private ApiStore apiStore;
    private ApplicationContext applicationContext;
    private final ParameterNameDiscoverer parameterNameDiscoverer;


    public ApiGatewayHand() {
        parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
        apiStore = new ApiStore(context);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        apiStore.loadApiFromSpringBeans();
    }

    /**
     * 处理请求.
     *
     * @param request  请求实体
     * @param response 响应实体
     */
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        // 初始变量
        ApiRunnable apiRunnable;
        ApiRequest apiRequest;
        Object result;
        try {
            apiRunnable = getApiRunnable(request);
            apiRequest = getApiRequest(request);
            Object[] args = buildParams(apiRunnable, request, response, apiRequest);
            result = apiRunnable.run(applicationContext, args);
        } catch (ApiException | IllegalAccessException | InvocationTargetException ex) {
            result = new ResultDto(false, ex.getMessage(), null);
        }

        //响应结果
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html/json;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            if (Objects.isNull(result)) {
                response.getWriter().write("{}");
            } else if (result instanceof ResultDto) {
                response.getWriter().write(JsonUtils.toJson(result));
            } else {
                response.getWriter().write(result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建一个参数.
     *
     * @param apiRunnable 反射对象
     * @param request     请求实体
     * @param response    响应实体
     * @param apiRequest  API请求实体
     * @return 反射对象.
     */
    private Object[] buildParams(ApiRunnable apiRunnable, HttpServletRequest request, HttpServletResponse response, ApiRequest apiRequest) {
        Method method = apiRunnable.getTargetMethod();
        List<String> paramNames = Arrays.asList(parameterNameDiscoverer.getParameterNames(method));
        Class<?>[] paramTypes = method.getParameterTypes();
        Annotation[][] annotations = method.getParameterAnnotations();
        if (paramTypes.length > 0) {
            String parameter = request.getParameter(PARAMETER);
            if (Objects.isNull(parameter) || Objects.equals(parameter.trim(), "")) {
                throw new ApiException("调用失败：参数 'parameter' 为空");
            }
            Map<String, Object> map;
            try {
                map = JsonUtils.toObject(parameter, Map.class);
            } catch (JSONException | JsonSyntaxException ex) {
                throw new ApiException("调用失败：参数 'parameter' 不是一个有效的JSON字符串");
            }

            //检查参数
            for (Map.Entry<String, Object> m : map.entrySet()) {
                if (!paramNames.contains(m.getKey())) {
                    throw new ApiException("调用失败：接口不存在‘" + m.getKey() + "’参数");
                }
            }

            //注入参数
            Object[] args = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                if (paramTypes[i].isAssignableFrom(HttpServletRequest.class)) {
                    args[i] = request;
                } else if (paramTypes[i].isAssignableFrom(ApiRequest.class)) {
                    args[i] = apiRequest;
                } else if (map.containsKey(paramNames.get(i))) {
                    try {
                        args[i] = JsonUtils.toBean(map.get(paramNames.get(i)), paramTypes[i]);
                    } catch (Exception e) {
                        throw new ApiException("调用失败：指定参数格式错误或值错误‘" + paramNames.get(i) + "’");
                    }
                } else {
                    boolean isNull = true;
                    for (Annotation annotation : annotations[i]) {
                        if (Objects.equals(annotation.annotationType(), NotNull.class)) {
                            isNull = false;
                            break;
                        }
                    }
                    if (!isNull) {
                        throw new ApiException("调用失败：参数 ‘" + paramNames.get(i) + "’ 不能为空");
                    }
                    args[i] = null;
                }
            }
            return args;
        }
        return new Object[]{};
    }

    /**
     * 获得 ApiRequest 对象.
     *
     * @param request 请求实体
     * @return ApiRequest 对象
     */
    private ApiRequest getApiRequest(HttpServletRequest request) {
        long time = ToType.toLong(request.getParameter("time"), -1);
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setAccessToken(request.getParameter("token"));
        apiRequest.setSign(request.getParameter("sign"));
        apiRequest.setTime(time);
        apiRequest.seteCode(request.getParameter("eCode"));
        apiRequest.setuCode(request.getParameter("uCode"));
        apiRequest.setParams(request.getParameter(PARAMETER));
        return apiRequest;
    }

    /**
     * 获得ApiRunnable 数据.
     *
     * @param request 请求实体
     * @return Runnable 对象
     */
    @NotNull
    private ApiRunnable getApiRunnable(HttpServletRequest request) {
        String name = request.getParameter(METHOD);
        ApiRunnable api;
        if (Objects.isNull(name) || Objects.equals(name.trim(), "")) {
            throw new ApiException("调用失败：参数 'method' 为空");
        } else if ((api = apiStore.findApiRunnable(name)) == null) {
            throw new ApiException("调用失败：指定API不存在，API: " + name);
        }
        return api;
    }


}
