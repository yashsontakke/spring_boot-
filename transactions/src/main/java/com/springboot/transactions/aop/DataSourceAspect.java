package com.springboot.transactions.aop;

import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {
	
	@Around("target(javax.sql.DataSource)")
	public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		
		System.out.println("Data Source tracker :" + proceedingJoinPoint.getSignature());
		
		Connection returnValue = (Connection) proceedingJoinPoint.proceed();   
		
		 // Step 2: Create proxy
        Connection proxyConnection = (Connection) Proxy.newProxyInstance(
            Connection.class.getClassLoader(),
            new Class[]{Connection.class},
            new ConnectionInvocationHandler(returnValue)
        );

		
		System.out.println(returnValue);
		return proxyConnection ;    
	}

}
