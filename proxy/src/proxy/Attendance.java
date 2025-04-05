package proxy;

import java.util.Date;

public class Attendance {
	
	private Date date;
	private boolean isPresnet ;
	
	public  Attendance (Date date , boolean isPresent) {
		super();
		this.date = date ;
		this.isPresnet = isPresent ;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isPresnet() {
		return isPresnet;
	}

	public void setPresnet(boolean isPresnet) {
		this.isPresnet = isPresnet;
	}
	
	
	
	
}
