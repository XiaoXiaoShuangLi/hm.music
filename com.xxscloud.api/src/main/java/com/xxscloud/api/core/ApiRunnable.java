package com.xxscloud.api.core;

import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 李小双 2018.2.22
 * API .
 */
public class ApiRunnable {

    /**
     * 名称 .
     */
    private String name;

    /**
     * ioc bean 名称.
     */
    private String targetName;

    /**
     * 实体.
     */
    private Object target;

    /**
     * 目标方法.
     */
    private Method targetMethod;

    /**
     * 注解对象.
     */
    private APIMapping apiMapping;

    /**
     * 执行方法.
     *
     * @param applicationContext 上下文
     * @param args               多个参数
     * @return 执行结果
     * @throws IllegalAccessException    访问异常
     * @throws IllegalArgumentException  参数异常
     * @throws InvocationTargetException 调用目标异常
     */
    public Object run(ApplicationContext applicationContext, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (target == null) {
            target = applicationContext.getBean(targetName);
        }
        return targetMethod.invoke(target, args);
    }

    /**
     * 获得参数类型.
     *
     * @return 类型
     */
    public Class<?>[] getParamTypes() {
        return targetMethod.getParameterTypes();
    }

    /**
     * 获得name 值.
     *
     * @return name 值
     */
    public String getName() {
        return name;
    }

    /**
     * 设置新nameValue值.
     *
     * @param nameValue 值
     */
    public void setName(String nameValue) {
        name = nameValue;
    }

    /**
     * 获得targetName 值.
     *
     * @return targetName 值
     */
    public String getTargetName() {
        return targetName;
    }

    /**
     * 设置新targetNameValue值.
     *
     * @param targetNameValue 值
     */
    public void setTargetName(String targetNameValue) {
        targetName = targetNameValue;
    }

    /**
     * 获得target 值.
     *
     * @return target 值
     */
    public Object getTarget() {
        return target;
    }

    /**
     * 设置新targetValue值.
     *
     * @param targetValue 值
     */
    public void setTarget(Object targetValue) {
        target = targetValue;
    }

    /**
     * 获得targetMethod 值.
     *
     * @return targetMethod 值
     */
    public Method getTargetMethod() {
        return targetMethod;
    }

    /**
     * 设置新targetMethodValue值.
     *
     * @param targetMethodValue 值
     */
    public void setTargetMethod(Method targetMethodValue) {
        targetMethod = targetMethodValue;
    }

    /**
     * 获得apiMapping 值.
     *
     * @return apiMapping 值
     */
    public APIMapping getApiMapping() {
        return apiMapping;
    }

    /**
     * 设置新apiMappingValue值.
     *
     * @param apiMappingValue 值
     */
    public void setApiMapping(APIMapping apiMappingValue) {
        apiMapping = apiMappingValue;
    }
}
