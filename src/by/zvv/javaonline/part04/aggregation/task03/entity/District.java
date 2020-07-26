package by.zvv.javaonline.part04.aggregation.task03.entity;

import java.util.HashSet;
import java.util.Set;

public class District {
	private String name;
	private Set<City> cities;
	private City districtCenter;
	private double area;

	public District() {
		cities = new HashSet<City>();
	}

	public District(String name, double area) {
		this();
		this.name = name;
		this.area = area;
	}

	public District(String name, Set<City> cities, double area) {
		this();
		this.name = name;
		this.cities = cities;
		this.area = area;
	}

	public District(String name, Set<City> cities, City districtCenter, double area) {
		this();
		this.name = name;
		this.cities = cities;
		this.districtCenter = districtCenter;
		this.area = area;
	}

	public void addCityToDistrict(City city) {
		cities.add(city);
	}

	public void remoteCityFromDistrict(City city) {
		cities.remove(city);
	}

	public int getPopulationSize() {
		int fullPopulationSize = 0;
		for (City city : cities) {
			fullPopulationSize += city.getPopulationSize();
		}
		return fullPopulationSize;
	}

	public double getArea() {
		return area;
	}

	public String getName() {
		return name;
	}

	public City getDistrictCenter() {
		return districtCenter;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public void setDistrictCenter(City districtCenter) {
		this.districtCenter = districtCenter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((districtCenter == null) ? 0 : districtCenter.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		District other = (District) obj;
		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
			return false;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		if (districtCenter == null) {
			if (other.districtCenter != null)
				return false;
		} else if (!districtCenter.equals(other.districtCenter))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", cities=" + cities + ", districtCenter="
				+ districtCenter + ", area=" + area + "]";
	}

}
