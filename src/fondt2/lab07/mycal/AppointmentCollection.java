package fondt2.lab07.mycal;

public class AppointmentCollection {
	
	private Appointment[] innerContainer;
	private int size;
	
	public AppointmentCollection(int k) {
		if(k > 0)
			innerContainer = new Appointment[k];
		else
			innerContainer = new Appointment[10];
		size = 0;
	}
	
	public AppointmentCollection() {
		this(10);
	}
	
	public int size() {
		return this.size;
	}
	
	public Appointment get(int k) {
		if(k >= 0 && k < size)
			return this.innerContainer[k];
		return null;
	}
	
	public void add(Appointment k) {
		if(size == innerContainer.length) {
			Appointment[] tmp = new Appointment[2*size];
			for(int i = 0; i < this.innerContainer.length &&  this.innerContainer[i] != null; i++)
				tmp[i] = this.innerContainer[i];
			this.innerContainer = tmp;
		}
		this.innerContainer[size] = k;
		this.size++;
	}
	
	public void remove(int k) {
		if(k >= 0 && k < size) {	
			int i;
			if(k == size-1) {
				this.innerContainer[k] = null;
			} else {
				for(i = k; i < size-1; i++)
					this.innerContainer[i] = this.get(i+1);
				this.innerContainer[i] = null;
			}
			this.size--;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.size && this.innerContainer[i] != null; i++) {
			sb.append(this.innerContainer[i].toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public int indexOf(Appointment app) {
		for(int i = 0; i < this.size; i++) {
			if(app.equals(innerContainer[i])) 
				return i;
		}
		return -1;
	}
	
}

