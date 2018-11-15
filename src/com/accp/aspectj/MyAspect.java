/**
 * @author Administrator
 *
 */
package com.accp.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    /**
     * 前置通知
     */
    @Before("execution(* com.accp.service.impl.DemoServiceImpl.getUser2(..))")
    public void before(){
        System.out.println("前置通知....");
    }
    
    /**
     * 后置通知
     */
    @After("execution(* com.accp.service.impl.DemoServiceImpl.insertUser(..))")
    public void after(){
        System.out.println("后置通知....");
    }
    
    /**
     * 环绕通知
     */
    @After("execution(* com.accp.service.impl.DemoServiceImpl.saveUser3(..))")
    public void around(){
        System.out.println("环绕通知....");
    }
}