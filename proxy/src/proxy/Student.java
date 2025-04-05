package proxy;

public class Student implements DailySession {

	Attendance attendance ;
	
	public Attendance getAttendance() {	
		return attendance;
		
	}
	public Student() {
		
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	@Override		
	public void attendLession(Integer id ) {
		System.out.println("attending the lession with id " + id);
		
	}

	public Student(Attendance attendance) {
		super();
		this.attendance = attendance;
	}

	@Override
	public void attendLession() {
		System.out.println("attending the lession ");
		
	}
	
	

}

