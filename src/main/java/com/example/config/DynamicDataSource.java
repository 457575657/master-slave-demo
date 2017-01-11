/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**  
 *<p> 动态的DataSource</p>
 *@Author:Yips
 *@Since:2017年1月10日 下午4:06:28 
 *@Version:1.1.0  
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // TODO Auto-generated method stub  
        return DynamicDataSourceHolder.getDataSource();
    }

}
