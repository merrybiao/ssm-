package com.accp.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PushJob {
	
	//@Scheduled(cron = "0/3 * * * * ?")
	public void run(){
		System.out.println("跑呀跑");
		
	}

}
