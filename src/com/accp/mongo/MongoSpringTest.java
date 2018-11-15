package com.accp.mongo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.entity.User2;
import com.accp.util.JedisUtils;
import com.google.gson.Gson;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MongoSpringTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;

    @Test
    public void testAddUser() {
    	DBCollection collection = mongoTemplate.getCollection("wurenbiao");
    	ArrayList<DBObject> arrayList = new ArrayList<DBObject>();
    	for(int i=0;i<100000;i++){
    		User2 user = new User2();
        	user.setId(1212);
        	user.setName("吴仁彪");
        	user.setSal(i*i*2);
        	Gson gson = new Gson();
        	DBObject db = (DBObject) JSON.parse(gson.toJson(user));
        	arrayList.add(db);
    	}
    	WriteResult res = collection.insert(arrayList);
    	System.out.println(res.getN());
    }
    
    @Test
    public void testQueryUser() {
    	DBCollection collection = mongoTemplate.getCollection("wurenbiao");
    	User2 user = new User2();
    	user.setId(1212);
    	Gson gson = new Gson();
    	DBObject db = (DBObject) JSON.parse(gson.toJson(user));
    	DBCursor res = collection.find(db);
    	while(res.hasNext()){
    		System.out.println(res.next());;
    	}
    }
    
    @Test
    public void testRedisUser() throws Exception {
    	 String set = JedisUtils.getInstance().set("wurenbiao", "cefsdcmks");
    	 System.out.println(set);
    }
    
    
}
