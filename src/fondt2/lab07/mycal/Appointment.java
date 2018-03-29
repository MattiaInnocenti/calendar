package fondt2.lab07.mycal;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Appointment {
	
	private String description;
	private LocalDateTime from;
	private LocalDateTime to;
	
	public Appointment(String description, LocalDateTime from, LocalDateTime to) {
		this.description = description;
		this.from = from;
		this.to = to;
	}
	
	public Appointment(String description, LocalDateTime from, Duration duration) {
		this.description = description;
		this.from = from;
		this.to = from.plus(duration);
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getFrom() {
		return this.from;
	}

	public void setFrom(LocalDateTime from) {
		this.from = from;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}
	
	public Duration getDuration() {
		return Duration.between(this.getFrom(), this.getTo());
	}
	
	public void setDuration(Duration duration) {
		if(this.getFrom() != null && this.getTo() != null)
			this.setTo(this.getFrom().plus(duration));
	}
	
	public boolean equals(Appointment app) {
		boolean res = false;
		if(this.getDescription().compareToIgnoreCase(app.getDescription()) == 0) {
			if((this.getFrom().isEqual(app.getFrom())) && (this.getTo().isEqual(app.getTo())))
				res = true;
		}
		return res;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter dateF = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		sb.append("Descrizione " + this.getDescription());
		sb.append("Inizio " + this.getFrom().format(dateF));
		sb.append("Fine " + this.getTo().format(dateF));
		return sb.toString();
	}
	
}
