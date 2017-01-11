/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.common.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ObjectUtils;

import com.example.common.constant.MemberEnum.MemberSexEnum;



/**  
 *<p> 会员实体对象</p>
 *@Author:Yips
 *@Since:2017年1月5日 上午9:08:38 
 *@Version:1.1.0  
 */
public class MemberPO implements Serializable {

   
    private static final long serialVersionUID = -4725699939691061981L;
    
    /**
     * 会员ID
     */
    private String memberId;
    
    /**
     * 会员名称
     */
    private String name;
    
    /**
     * 手机号码
     */
    private String mobile;
    
    /**
     * 性别
     */
    private int sex;
    
    /**
     * 出生日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    
    /**
     * 备注 
     */
    private String remark;

    /**  
     * @return the memberId  
     */
    public String getMemberId() {
        return memberId;
    }

    /**  
     * @param memberId the memberId to set  
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**  
     * @return the name  
     */
    public String getName() {
        return name;
    }

    /**  
     * @param name the name to set  
     */
    public void setName(String name) {
        this.name = name;
    }

    /**  
     * @return the mobile  
     */
    public String getMobile() {
        return mobile;
    }

    /**  
     * @param mobile the mobile to set  
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**  
     * @return the sex  
     */
    public int getSex() {
        return sex;
    }

    /**  
     * @param sex the sex to set  
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**  
     * @return the birthday  
     */
    public Date getBirthday() {
        return birthday;
    }

    /**  
     * @param birthday the birthday to set  
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**  
     * @return the remark  
     */
    public String getRemark() {
        return remark;
    }

    /**  
     * @param remark the remark to set  
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * 获取会员性别文本
     * <p> </p>
     * @return  
     * @throws
     */
    public String getSexText(){
        return MemberSexEnum.getValueByKey(this.sex);
    }
    
    public String getBirthdayFormat(){
        
        if ( ObjectUtils.isEmpty(this.birthday) ) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.birthday);
        
    }

}
