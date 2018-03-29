package fondt2.lab07.mycal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MyCalendar {
	
	private AppointmentCollection apps;
	private static final LocalTime MID_NIGHT = LocalTime.of(0,0,0);
	
	public MyCalendar() {
		apps = new AppointmentCollection();
	}	
	
	public void add(Appointment app) {
		apps.add(app);
	}
	
	public boolean remove(Appointment app) {
		if(this.apps.indexOf(app) != -1) {
			this.apps.remove(this.apps.indexOf(app));
			return true;
		} else
			return false;
	}
	
	public AppointmentCollection getAllAppointments() {
		AppointmentCollection res = new AppointmentCollection();
		for(int i = 0; i < this.apps.size(); i++)
			res.add(this.apps.get(i));
		return res;
	}
	
	public AppointmentCollection getDayAppointments(LocalDate date) {
		LocalDateTime from = LocalDateTime.of(date, MyCalendar.MID_NIGHT);
		LocalDateTime to = LocalDateTime.of(date.plusDays(1), MyCalendar.MID_NIGHT);
		
		return fill(from, to);
	}
	
	public AppointmentCollection getMonthAppointments(LocalDate date) {
		LocalDateTime from = LocalDateTime.of(date, MyCalendar.MID_NIGHT);
		LocalDateTime to = LocalDateTime.of(date.plusMonths(1), MyCalendar.MID_NIGHT);
	
		return fill(from, to);
	}
	
	public AppointmentCollection getWeekAppointments(LocalDate date) {
		int dayNumber = date.getDayOfWeek().getValue();
		LocalDateTime from, to;
		if(dayNumber == 1) { 
			from = LocalDateTime.of(date, MyCalendar.MID_NIGHT);
			to = from.plusWeeks(1);
			return fill(from, to);
		} else { 
			LocalDate res = date.minusDays(dayNumber-1);
			from = LocalDateTime.of(res, MyCalendar.MID_NIGHT);
			to = from.plusWeeks(1);
			return fill(from, to);
		}
	}
	
	private AppointmentCollection fill(LocalDateTime from, LocalDateTime to) {
		AppointmentCollection res = new AppointmentCollection();
		for(int i = 0; i < this.apps.size(); i++) {
			Appointment tmp = apps.get(i);
			if(tmp.getFrom().isAfter(from) && tmp.getFrom().isBefore(to))
				res.add(tmp);
		}
		return res;
	}
	
	
}
