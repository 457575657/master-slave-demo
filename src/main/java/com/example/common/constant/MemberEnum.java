/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example.common.constant;  
  
  
/**  
 *<p> </p>
 *@Author:Yips
 *@Since:2017年1月4日 上午8:56:46 
 *@Version:1.1.0  
 */
public class MemberEnum {

    public enum MemberSexEnum {
        MALE(0,"男"), FEMALE(1,"女");
        private int key;
        private String value;
        
        private MemberSexEnum( int key,String value) {
            this.key = key;
            this.value = value;
        }

        
        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
        

        /**
         * <p> 通过可以获取枚举的值</p>
         * @param key
         * @return  
         * @throws
         */
        public static String getValueByKey(int key) {
            for (MemberSexEnum en : MemberSexEnum.values()){
                if ( en.key == key) {
                    return en.value;
                }
            }
            return null;
        }
           
           
        /** 
         * <p>通过key获取类型对象</p> 
         * @param key
         * @return 
         * @throws
         */
         public static MemberSexEnum newInstance(int key) {
             for (MemberSexEnum en : MemberSexEnum.values()){
                 if ( en.key == key ){
                     return en;
                 }
             }
             return null;
         }

        
    }
}
