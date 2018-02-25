package com.xxscloud.api.core;


import org.springframework.context.ApplicationContext;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author 李小双 2018.2.22
 * API IOC 注册中心.
 */
public class ApiStore {
    private ApplicationContext applicationContext;

    private HashMap<String, ApiRunnable> apiMap = new HashMap<>();


    public ApiStore(ApplicationContext applicationContext) {
        //Assert.notNull(applicationContext);
        this.applicationContext = applicationContext;
    }

    /**
     * 扫描APIMapping 文件类.
     */
    public void loadApiFromSpringBeans() {
        String[] names = applicationContext.getBeanDefinitionNames();
        Class<?> type;
        for (String name : names) {
            type = applicationContext.getType(name);
            for (Method m : type.getDeclaredMethods()) {
                //是否被APIMapping 注解
                APIMapping apiMapping = m.getAnnotation(APIMapping.class);
                if (apiMapping != null) {
                    //添加到Map
                    ApiRunnable apiRunnable = new ApiRunnable();
                    apiRunnable.setName(apiMapping.value());
                    apiRunnable.setTargetMethod(m);
                    apiRunnable.setTargetName(name);
                    apiRunnable.setApiMapping(apiMapping);
                    apiMap.put(apiMapping.value(), apiRunnable);
                }
            }
        }
    }

    /**
     * 查找对应的APIMapping 的反射类
     *
     * @param name 名称
     * @return 反射类
     */
    public ApiRunnable findApiRunnable(String name) {
        return apiMap.get(name);
    }

//
//    public ApiRunnable findApiRunnable(String apiName, String version) {
//        return (ApiRunnable) apiMap.get(apiName + "_" + version);
//    }
//
//    public List<ApiRunnable> findApiRunnables(String apiName) {
//        if (apiName == null) {
//            throw new IllegalArgumentException("api name must not null!");
//        }
//        List<ApiRunnable> list = new ArrayList<ApiRunnable>(20);
//        for (ApiRunnable api : apiMap.values()) {
//            if (api.apiName.equals(apiName)) {
//                list.add(api);
//            }
//        }
//        return list;
//    }
//
//    public List<ApiRunnable> getAll() {
//        List<ApiRunnable> list = new ArrayList<ApiRunnable>(20);
//        list.addAll(apiMap.values());
//        Collections.sort(list, new Comparator<ApiRunnable>() {
//            public int compare(ApiRunnable o1, ApiRunnable o2) {
//                return o1.getApiName().compareTo(o2.getApiName());
//            }
//        });
//        return list;
//    }
//
//    public boolean containsApi(String apiName, String version) {
//        return apiMap.containsKey(apiName + "_" + version);
//    }


}
