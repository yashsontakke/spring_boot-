package dto;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		
		 // Step 1: Create the real object
		ItEmployee itEmployee = new ItEmployee();
		
		itEmployee.setId(10);
		itEmployee.setName("yash");
		itEmployee.setSalary(2498);
		
		itEmployee.giveHike(324235);
		System.out.println(itEmployee.getSalary());
		
		// Step 2: Create the handler and pass the real object
		EmployeeInvocationHandler employeeInvocationHandler = new EmployeeInvocationHandler(itEmployee);
		
		
		// Step 3: Create the proxy
        IEmployee employee= (IEmployee) Proxy.newProxyInstance(
                IEmployee.class.getClassLoader(),
                new Class[] { IEmployee.class },
                employeeInvocationHandler
        );

        // Step 4: Use the proxy
      
        employee.giveHike(100);
        employee.getSalary();
		
	}
}
