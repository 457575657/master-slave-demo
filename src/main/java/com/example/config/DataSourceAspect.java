/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.config;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**  
 *<p>DataSource AOP  </p>
 *@Author:Yips
 *@Since:2017年1月10日 下午4:12:30 
 *@Version:1.1.0  
 */
public class DataSourceAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
    
    public void before (JoinPoint point) {
        
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        try {
            
            Method m = classz[0].getMethod(method, parameterTypes);
            
            if( m!=null && m.isAnnotationPresent(DataSource.class)) {
                DataSource dataSource = m.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.putDataSource(dataSource.value());
                logger.info("========> get DataSource:  " + dataSource.value());
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("=============>"+e.getMessage());
        }
    }

}
