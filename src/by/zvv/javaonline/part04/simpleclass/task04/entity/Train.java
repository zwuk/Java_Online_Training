package by.zvv.javaonline.part04.simpleclass.task04.entity;

public class Train {
	
	private String destination;
	private int number;
	private MyTime departureTime;
	
	{
		departureTime = new MyTime(0);
	}

	public Train() {
		
	}

	public Train(int number) {
		this.number = number;
	}

	public Train(String destination) {
		this.destination = destination;
	}

	public Train(String destination, int number) {
		this.destination = destination;
		this.number = number;
	}

	public Train(String destination, int number, MyTime departureTime) {
		this.destination = destination;
		this.number = number;
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public int getNumber() {
		return number;
	}

	public MyTime getDepartureTime() {
		return departureTime;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setDepartureTime(MyTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		StringBuilder train = new StringBuilder();
		train.append(getClass().getSimpleName())
			.append(": [destination=")
			.append(destination)
			.append(", number=")
			.append(number)
			.append(", departureTime(seconds)=")
			.append(departureTime)
			.append("]");
		return train.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	
}
