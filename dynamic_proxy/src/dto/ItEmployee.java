package dto;

public class ItEmployee implements IEmployee{

	private int id ;
	
	private String name;

	
	private double salary ;
	
	@Override
	public void giveHike(double amount) {
		// TODO Auto-generated method stub
		this.salary+=amount;
	}

	@Override
	public void payCut(double amount) {
		// TODO Auto-generated method stub
		this.salary-=amount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
