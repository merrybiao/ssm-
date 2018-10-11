package com.accp.Annonion;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.accp.entity.User;
/**
 * 
 * @author Administrator
 *
 */
public interface AnnonionUser {
	
	@Select("select * from user where id = #{id}")
	public User getAllUser(@Param(value = "id") Long id);
	
}
