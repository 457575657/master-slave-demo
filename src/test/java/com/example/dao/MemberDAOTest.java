/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.example.MasterSlaveDemoApplication;
import com.example.common.domain.MemberPO;


/**  
 *<p> </p>
 *@Author:Yips
 *@Since:2017年1月5日 下午2:52:40 
 *@Version:1.1.0  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MasterSlaveDemoApplication.class)
public class MemberDAOTest {

  @Autowired
  private MemberDAO memberDAO;
    
    @Test
    public void getMemberById () {
        String id = "asdfsdf";
        MemberPO po = memberDAO.queryById(id);
        System.out.println("====>" + JSON.toJSONString(po));
    }
    
    @Test
    public void  save () {
        
        MemberPO  po = new MemberPO();
        po.setBirthday(new Date());
        po.setMobile("18000000000");
        po.setName("Yips");
        po.setRemark("testTEST");
        po.setSex(1);
        
        memberDAO.save(po);
        System.out.println("====>" + po.getMemberId() );
        
        System.out.println("====>" + JSON.toJSONString(po));
    }
    
    @Test
    public void update () {
        MemberPO  po = new MemberPO();
        po.setMemberId("4a45beab-d319-11e6-9e17-f48e38ad3930");
        po.setMobile("18000000000");
        po.setRemark("test_test_test");
        po.setSex(1);
        memberDAO.update(po);
    }
    
    @Test
    public void delete (){
        String id = "cf881cc2-d31c-11e6-9e17-f48e38ad3930";
        memberDAO.delete(id);
    } 
    
    @Test
    public void queryByParam () {
        Map<String,Object> param = new HashMap<String,Object>();
//        param.put("sex", 1);
        param.put("name", "Yips");
        param.put("mobile", "18000000000");
        List<MemberPO> poList = memberDAO.queryListByParam(param);
        System.out.println( "====>" + poList.size());
        System.out.println("=======>" + JSON.toJSONString(poList));
    }
    
}
