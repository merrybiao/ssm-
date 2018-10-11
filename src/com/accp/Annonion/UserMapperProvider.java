package com.accp.Annonion;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class UserMapperProvider {
	
	public String select(final Map<String,Object> map){
        return new SQL(){
            {
                SELECT( " t.`user_source` ,"
					  + " t.`id_card` ,"
					  + " t.`addr`,"
					  + " t.`real_name` ,"
					  + " t.`phone_remain`,"
					  + " t.`phone`,"
					  + " DATE_FORMAT(t.`reg_time` ,'%Y-%m-%d %H:%i:%S') as reg_time,"
					  + " DATE_FORMAT(IFNULL(t.update_time,t.create_time),'%Y-%m-%d %T') as updateTime,"
					  + " t.`score` ,"
					  + " t.`contact_phone` ,"
					  + " t.`star_level` ,"
					  + " t.`authentication` ,"
					  + " t.`phone_status` ,"
					  + " t.`package_name`");
                FROM("user");
                StringBuffer sb = new StringBuffer();
                if(map.get("id") != null){
                    sb.append(" and id= '"+map.get("id")+"'");
                }
                if(!sb.toString().equals("")){
                    WHERE(sb.toString().replace("and", ""));
                }
            }
        }.toString();
    }
	
	public String insert(final Map<String,Object> map){
        return new SQL(){
            {
            	 INSERT_INTO("User");     
                 //条件写法.
               if(map.containsKey("sal")){
                  VALUES("sal","#{sal}");
               }
              if(map.containsKey("name")){
                  VALUES("name","#{name}");
               }
            }
        }.toString();
    }
}
