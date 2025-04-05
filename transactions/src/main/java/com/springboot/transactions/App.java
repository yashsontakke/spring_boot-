package com.springboot.transactions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.transactions.config.ProductConfig;
import com.springboot.transactions.service.ProductService;

public class App 
{
    public static void main( String[] args )
    {
    	  System.out.println( "Hello World!" );
//        
//        In Spring (non-Boot): You must explicitly register configuration classes in AnnotationConfigApplicationContext.
//        🔹 In Spring Boot: The @SpringBootApplication annotation enables auto-scanning and auto-configuration.
        
    	  
    	  //AnnotationConfigApplicationContext comes from Spring Core/Context, not Spring Boot.
    	  
    	  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	  
    	  //Registers a shutdown hook so that the context closes automatically when the JVM shuts down.
    	  context.registerShutdownHook();    	  
    	  context.register(ProductConfig.class);
    	  
    	  context.refresh();
    	  
    	  ProductService productService=  context.getBean("productService" ,ProductService.class);
    	 
    	 
    	  try {
			productService.saveProductInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	      	      	         
        
    	  context.close(); // Properly shuts down the context 
    	  // as we have registered shutdown context will automatically close when jvm closes 
    }
}
