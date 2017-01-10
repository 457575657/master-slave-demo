/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


/**  
 *<p> </p>
 *@Author:Yips
 *@Since:2017年1月10日 下午4:46:55 
 *@Version:1.1.0  
 */
@Configuration
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    
    @Autowired
    private Environment env;
    
    
    //主库写
    @Bean(name="writeDataSource")
    public DataSource writeDataSource () {
        
        try {
           Properties props = new Properties();
           
           props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
           props.put("url", env.getProperty("master.jdbc.url"));
           props.put("username", env.getProperty("master.jdbc.username"));
           props.put("password", env.getProperty("master.jdbc.password"));
           props.put("filters", env.getProperty("jdbc.filters"));
           props.put("initialSize", env.getProperty("jdbc.initialSize"));
           props.put("maxActive", env.getProperty("jdbc.maxActive"));
           props.put("maxWait", env.getProperty("jdbc.maxWait"));
           props.put("timeBetweenEvictionRunsMillis", env.getProperty("jdbc.timeBetweenEvictionRunsMillis"));
           props.put("minEvictableIdleTimeMillis", env.getProperty("jdbc.minEvictableIdleTimeMillis"));
           props.put("validationQuery", env.getProperty("jdbc.validationQuery"));
           props.put("testWhileIdle", env.getProperty("jdbc.testWhileIdle"));
           props.put("testOnBorrow", env.getProperty("jdbc.testOnBorrow"));
           props.put("testOnReturn", env.getProperty("jdbc.testOnReturn"));
           props.put("poolPreparedStatements", env.getProperty("jdbc.poolPreparedStatements"));
           props.put("maxPoolPreparedStatementPerConnectionSize",
             env.getProperty("jdbc.maxPoolPreparedStatementPerConnectionSize"));
           
            return DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            logger.error("========================>wirteDataSource " + e.getMessage());
        }
        return null;
    }
    
    //丛库读
    @Bean(name="readDataSource")
    public DataSource readDataSource() {
        
        try {
            Properties props = new Properties();
            
            props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
            props.put("url", env.getProperty("slave.jdbc.url"));
            props.put("username", env.getProperty("slave.jdbc.username"));
            props.put("password", env.getProperty("slave.jdbc.password"));
            props.put("filters", env.getProperty("jdbc.filters"));
            props.put("initialSize", env.getProperty("jdbc.initialSize"));
            props.put("maxActive", env.getProperty("jdbc.maxActive"));
            props.put("maxWait", env.getProperty("jdbc.maxWait"));
            props.put("timeBetweenEvictionRunsMillis", env.getProperty("jdbc.timeBetweenEvictionRunsMillis"));
            props.put("minEvictableIdleTimeMillis", env.getProperty("jdbc.minEvictableIdleTimeMillis"));
            props.put("validationQuery", env.getProperty("jdbc.validationQuery"));
            props.put("testWhileIdle", env.getProperty("jdbc.testWhileIdle"));
            props.put("testOnBorrow", env.getProperty("jdbc.testOnBorrow"));
            props.put("testOnReturn", env.getProperty("jdbc.testOnReturn"));
            props.put("poolPreparedStatements", env.getProperty("jdbc.poolPreparedStatements"));
            props.put("maxPoolPreparedStatementPerConnectionSize",
              env.getProperty("jdbc.maxPoolPreparedStatementPerConnectionSize"));
            
             return DruidDataSourceFactory.createDataSource(props);
         } catch (Exception e) {
             // TODO: handle exception
        	 e.printStackTrace();
             logger.error("========================>readDataSource " + e.getMessage());
         }
        
        return null;
    }
    
    //主数据源
    @Bean(name = "dynamicDataSource")
    @Primary
    public AbstractRoutingDataSource dataSource (  @Qualifier("writeDataSource") DataSource write,  @Qualifier("readDataSource") DataSource read) {
        
        Map<Object,Object> targetDataSources = new HashMap<Object,Object>();
        targetDataSources.put("writeDataSource", write);
        targetDataSources.put("readDataSource", read);
        
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(write);
        return dataSource;
    }
    
    //配置DataSourceTransactionManager
    @Bean(name = "transactionManager")
    @ConditionalOnMissingBean
    public DataSourceTransactionManager transactionManager ( DataSource writeDataSource, DataSource readDataSource) {
        
        return new DataSourceTransactionManager(this.dataSource(writeDataSource, readDataSource));
        
    }
    
    //配置sqlSessionFactory
    @Bean(name = "sqlSessionFactory")
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory ( DataSource dataSource ) throws Exception {
        
        final  SqlSessionFactoryBean sessionFactory = new  SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
        return sessionFactory.getObject();
    }
    
    
}
