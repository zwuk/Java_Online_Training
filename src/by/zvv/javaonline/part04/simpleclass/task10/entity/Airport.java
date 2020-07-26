package by.zvv.javaonline.part04.simpleclass.task10.entity;

import java.util.ArrayList;
import java.util.List;

public class Airport {
	private List<Airline> airlines;

	public Airport() {
		airlines = new ArrayList<>();
	}

	public void addAirline(Airline airline) {
		airlines.add(airline);
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlines == null) ? 0 : airlines.hashCode());
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
		Airport other = (Airport) obj;
		if (airlines == null) {
			if (other.airlines != null)
				return false;
		} else if (!airlines.equals(other.airlines))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [airlines=" + airlines + "]";
	}

	
}
