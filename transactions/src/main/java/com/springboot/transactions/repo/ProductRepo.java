package com.springboot.transactions.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.transactions.dto.Product;

@Repository
public class ProductRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public void saveProduct(Product product) {
		
		String sql = "INSERT INTO PRODUCT VALUES (?,?)";
		
		Object[] args = {product.getId() , product.getName()};
		
		jdbcTemplate.update(sql,args);
		
		System.out.print("product Saved");
		
	}

} 
