/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.common.domain.MemberPO;
import com.example.config.DataSource;


/**
 *  Dev2 Remark
 */

/**  
 *<p> 会员DAO </p>
 *@Author:Yips
 *@Since:2017年1月5日 上午9:14:39 
 *@Version:1.1.0  
 */
@Repository
public interface MemberDAO  {
    
    /**
     * <p>保存实体对象</p> 
     * @param obj 
     * @throws
     */
    @DataSource("writeDataSource")
     int save(MemberPO object);
      
      /**
       * 删除指定id的实体对象
       * @param id
       */
    @DataSource("writeDataSource")
      int delete(String id);
      
      
      /**
       * 更新的实体对象
       * @param id
       * @param obj
       */
    @DataSource("writeDataSource")
      int update(MemberPO object);
      
      /**
       * 返回持久化对象
       * @param id
       * @return
       */
    @DataSource("readDataSource")
      MemberPO queryById(String id);
      
      /**
       * 返回所有持久化对象
       * @return
       */
    @DataSource("readDataSource")
      List<MemberPO> queryList();
    
    
    /**
     * 
     * <p>多条件组合查询会员列表  </p>
     * @param param
     * @return  
     * @throws
     */
    @DataSource("readDataSource")
    List<MemberPO> queryListByParam (@Param("param") Map<String,Object>param);
}
