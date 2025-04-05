package com.springboot.transactions.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.transactions.dto.Product;
import com.springboot.transactions.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Transactional(rollbackFor= Exception.class) 			// IF WE ARE THROWING CHECKED EXCEPTION WE HAVE TO DEFINE ROLLBACK  
	public void saveProductInfo()  {
		
		
		for(int i=0;i<10;i++) {
			Product product = new Product();
			product.setId(i);
			product.setName("product"+"-"+i);
			
			productRepo.saveProduct(product);
		}
		
	}
}

//
//🛠 Best Practices for Exception Handling in Transactions
//
//✔ Avoid catching exceptions inside transactional methods unless you explicitly want to handle rollback manually.
//✔ Use rollbackFor = Exception.class if you want checked exceptions to trigger rollback.
//✔ Use noRollbackFor for exceptions that should not cause rollback.
//✔ Use TransactionAspectSupport.currentTransactionStatus().setRollbackOnly() to manually trigger rollback.