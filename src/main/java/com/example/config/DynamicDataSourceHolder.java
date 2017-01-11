/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.config;  
  
  
/**  
 *<p> </p>
 *@Author:Yips
 *@Since:2017年1月10日 下午4:08:11 
 *@Version:1.1.0  
 */
public class DynamicDataSourceHolder {
    
    //用到了线程的本地变量，但是要及时删掉
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();
    
    public static void putDataSource (String name) {
        holder.set(name);
    }
    
    public static String getDataSource () {
        String dataSource = holder.get();
        holder.remove();
        return dataSource;
    }
     
}
