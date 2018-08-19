package com.edu.finance.framework.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 */
public class SpringContextHolder implements ApplicationContextAware {
    protected static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    /**
     * 获得spring容器中对象
     * @param beanName 对象名称
     * @return 对象
     */
    public static Object getBean(String beanName) {
        if(context != null) {
            return context.getBean(beanName);
        } else {
            return null;
        }
    }
    
    /**
     * 获得spring容器中对象
     * @param 类(可以直接传接口的class)
     * @return 对象
     */
    public  static <T>  T getBean(Class<T> clazz){
        if(context != null){
            return context .getBean(clazz);
        }else{
            return null;
        }
    }
}
