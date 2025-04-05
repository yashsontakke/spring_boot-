package dto;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeInvocationHandler implements InvocationHandler {

	IEmployee itEmployee;
	
	
	public EmployeeInvocationHandler(IEmployee iEmployee) {
		this.itEmployee = iEmployee;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		// pre processing 
		if(method.getName().equals("giveHike")) {
			double hikeValue = (double) args[0];
			if(hikeValue<=0.0) {
				throw new RuntimeException("invalid hike amount");
			}
			
		}
			
		Object returnValueObject = method.invoke(itEmployee, args);
		
		// post processing 
		
		System.out.println(returnValueObject);
		
		return returnValueObject;
	}

}
