package com.accp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.accp.Annonion.AnnonionUser;
import com.accp.Annonion.UserMapper;
import com.accp.dao.ResultMapMapper;
import com.accp.dao.UserDao;
import com.accp.entity.Animal;
import com.accp.entity.User;
import com.accp.mymapper.UserMapper2;
import com.accp.service.DemoService;
import com.alibaba.fastjson.JSON;

@Service
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private AnnonionUser annonionuser;
	
	@Autowired
	private UserMapper usermapper;
	
	@Autowired
	private UserMapper2 usermapper2;
	
	@Autowired
	private ResultMapMapper resultmapmapper;

	@Override
	public int saveUser(Long id) {
		
		int inid1 = dao.deleteByPrimaryKey(id);

		return inid1;
	}
	
	@Override
	public User getUser(Long id) {
	
		User user = annonionuser.getAllUser(id);
		
		return user;
	}
	
	@Override
	public Integer insertUser(Map<String,String> map) {
	
		Integer id = usermapper.insertUser(map);
		
		return id;
	}
	
	@Override
	public List<User> getUser2(Long id) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id+"");
		List<User> list = usermapper.getUserAll(map);
		
		return list;
	}

	@Override
	public Animal getAnimalById(Long id) {
	
		Animal findAnimalById = resultmapmapper.findAnimalById(id);
		return findAnimalById;
	}

	@Override
	public List<User> saveUser3(Long id) {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		//criteria.andEqualTo("id", id);
		criteria.andBetween("id", 0, 20);
		example.setOrderByClause("id desc");
		
		/*int selectCountByExample = usermapper2.selectCountByExample(example);
		
		System.out.println(selectCountByExample);*/
		List<User> list = usermapper2.selectByExample(example);
		User us = new User();
		us.setName("小红花");
		us.setSal(1515);
		usermapper2.insert(us);
		for (User user : list) {
			System.out.println(JSON.toJSONString(user));
		}
		return list;
	}
}
