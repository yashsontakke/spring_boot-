package com.springboot.transactions.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CallTracker {
	
	@Pointcut("within(com.springboot.transactions.service.*) || within(com.springboot.transactions.repo.*) ")
	public void logMethodPointCut(){
		
	}
	
	
//	@Before("logMethodPointCut()")
//	public void logBeforeMethodCall() {
//		System.out.println("method is starting");
//	}
//
//	
//	
//	@After("logMethodPointCut()")
//	public void logAfterMethodCall() {
//		System.out.println("method is ending");
//	}
	
	@Around("logMethodPointCut()")
	public Object logAroundMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String name = proceedingJoinPoint.getSignature().getName();
		// before 
		System.out.println("method start :" + name);
		
		
		// call method 
		Object returnValue = proceedingJoinPoint.proceed();
		
		
		// after method 
		System.out.println("method completed :" + name);
		
		
		return returnValue;
		
	}
	
	
	
	
	
}
 