package com.springboot.transactions.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;



public class ConnectionInvocationHandler implements InvocationHandler {

    private final Connection realConnection;

    public ConnectionInvocationHandler(Connection realConnection) {
        this.realConnection = realConnection;
    }

    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	
    	if ("commit".equals(method.getName()) || "rollback".equals(method.getName())) {
    		 System.out.println("[Connection Proxy] Method called: " + method.toGenericString());
        }
        // Logging
//        System.out.println("[Connection Proxy] Method called: " + method.getName());

        // Example: intercept specific method
        if ("close".equals(method.getName())) {
            System.out.println("[Connection Proxy] Connection is being closed.");
        }

        // Call the real method on the underlying connection
        return method.invoke(realConnection, args);
    }

	
}