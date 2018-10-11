package com.accp.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.entity.Animal;
import com.accp.entity.User;
import com.accp.service.DemoService;

@RequestMapping("demo/")
@Controller
public class DemoController {
	
	@Autowired
	private DemoService demoserviceimpl;
	
	@RequestMapping("test1.do")
	@ResponseBody
	public String demo(String name){
		int resp   = demoserviceimpl.saveUser(Long.parseLong(name));
		return resp+"";
	}
	
	@RequestMapping("test2.do")
	@ResponseBody
	public User demo2(String id){
		User resp   = demoserviceimpl.getUser(Long.parseLong(id));
		return resp;
	}

	@RequestMapping("test3.do")
	@ResponseBody
	public List<User> demo3(String id){
		List<User> resp   = demoserviceimpl.getUser2(Long.parseLong(id));
		return resp;
	}
	
	@RequestMapping("test4.do")
	@ResponseBody
	public Animal demo4(String id){
		Animal resp   = demoserviceimpl.getAnimalById(Long.parseLong(id));
		return resp;
	}
	
	@RequestMapping(value = "test5.do")
	@ResponseBody
	public Integer demo4(HttpServletRequest request){
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("name", request.getParameter("name"));
		hashMap.put("sal", request.getParameter("sal"));
		Integer insertUser = demoserviceimpl.insertUser(hashMap);
		return insertUser;
	}
	
	@RequestMapping(value = "test6.do")
	@ResponseBody
	public List<User> demo6(HttpServletRequest request){
		HashMap<String, String> hashMap = new HashMap<String, String>();
		Long id = Long.parseLong(request.getParameter("id"));
		List<User> insertUser = demoserviceimpl.getUser3(id);
		return insertUser;
	}
}
