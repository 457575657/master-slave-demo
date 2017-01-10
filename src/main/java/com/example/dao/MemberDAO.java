/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.common.BaseDAO;
import com.example.common.domain.MemberPO;



/**  
 *<p> 会员DAO </p>
 *@Author:Yips
 *@Since:2017年1月5日 上午9:14:39 
 *@Version:1.1.0  
 */
public interface MemberDAO extends BaseDAO<MemberPO> {
     
    /**
     * 
     * <p>多条件组合查询会员列表  </p>
     * @param param
     * @return  
     * @throws
     */
    List<MemberPO> queryListByParam (@Param("param") Map<String,Object>param);
}
