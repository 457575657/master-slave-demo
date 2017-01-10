/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.common;

import java.util.List;

/**  
 *<p>MyBatis 基础DAO </p>
 *@Author:Yips
 *@Since:2017年1月5日 上午9:03:44 
 *@Version:1.1.0  
 */
public interface BaseDAO<T> {
    /**
     * <p>保存实体对象</p> 
     * @param obj 
     * @throws
     */
     int save(T object);
      
      /**
       * 删除指定id的实体对象
       * @param id
       */
      int delete(String id);
      
      
      /**
       * 更新的实体对象
       * @param id
       * @param obj
       */
      int update(T object);
      
      /**
       * 返回持久化对象
       * @param id
       * @return
       */
      T queryById(String id);
      
      /**
       * 返回所有持久化对象
       * @return
       */
      List<T> queryList();
}
