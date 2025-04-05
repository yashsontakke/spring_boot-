package proxy;



public class StudentProxy extends Student {

	
//	If the parent doesn't have a default constructor, then:
//
//	You must explicitly define a constructor in the child.
//	And in that constructor, you must call the parent’s constructor with arguments using super(args...).
	
	public StudentProxy(Attendance attendance) {
		super(attendance);
		// TODO Auto-generated constructor stub
	}
	 
	@Override		
	public void attendLession() {			
		if(super.getAttendance().isPresnet()) {
			super.attendLession(); // proxy makes a real call 
		}else {
			throw new RuntimeException("student is not present ");
		}	
		
	}

}
