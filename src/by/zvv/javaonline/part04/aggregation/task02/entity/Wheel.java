package by.zvv.javaonline.part04.aggregation.task02.entity;

import by.zvv.javaonline.part04.aggregation.task02.enums.Season;

public class Wheel {
	private Season season;
	private int diameter;

	public Wheel() {
		diameter = 15;
		season = Season.SUMMER;
	}
	
	public Wheel(Season season, int diameter) {
		this.season = season;
		this.diameter = diameter;
	}
	
	public Season getSeason() {
		return season;
	}
	
	public int getDiameter() {
		return diameter;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [season=" + season + ", diameter=" + diameter + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diameter;
		result = prime * result + ((season == null) ? 0 : season.hashCode());
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
		Wheel other = (Wheel) obj;
		if (diameter != other.diameter)
			return false;
		if (season != other.season)
			return false;
		return true;
	}
	
}
