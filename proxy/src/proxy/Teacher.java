package proxy;

import java.util.Date;

public class Teacher {
	
	
	public static void main(String[] args) {
		// CLIENT TEACHER IS INTERACTING WITH PROXY 
		DailySession dailySession = new StudentProxy( new Attendance(new Date(), false));
		dailySession.attendLession();
	}
	
}
