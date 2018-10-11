package com.accp.Annonion;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import com.accp.entity.User;

/**
 * 第八次测试github修改文件
 * @author Administrator
 *
 */
public interface UserMapper {
	
	/**
	 * 第四次测试
	 */
	@SelectProvider(type=UserMapperProvider.class,method="select")
	public List<User> getUserAll(Map<String, String> map);
	
	/*返回受影响的行数*/
	@InsertProvider(type=UserMapperProvider.class,method="insert")
	public Integer insertUser(Map<String, String> map);
	
}
