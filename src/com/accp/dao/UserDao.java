package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.entity.User;

import example.UserExample;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @param <User> The User Class 这里是泛型不是User类
 * @param <PK> The Primary Key Class 如果是无主键，则可以用User来跳过，如果是多主键则是Key类
 * @param <E> The Example Class
 */
public interface UserDao {
	
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}