package com.accp.zookeeper;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZookeeperStart {
	
		public static void main(String[] args) throws IOException {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		    context.start();
		    System.out.println("----------------服务已启动，按任意键结束···········--------------------");
		    System.in.read();
		}
	}
