package com.accp.service;

import java.util.List;
import java.util.Map;

import com.accp.entity.Animal;
import com.accp.entity.User;


public interface DemoService {
	
	public int saveUser(Long id);
	
	public User getUser(Long id);
	
	public List<User> saveUser3(Long id);
	
	public Integer insertUser(Map<String,String> map);
	
	public List<User> getUser2(Long id);
	
	public Animal getAnimalById(Long id);

}
