package by.zvv.javaonline.part04.aggregation.task03.entity;

import java.util.HashSet;
import java.util.Set;

public class Region {
	private String name;
	private Set<District> distriсts;
	private City regionCenter;

	public Region() {
		distriсts = new HashSet<District>();
	}

	public Region(String name) {
		this();
		this.name = name;
	}

	public Region(String name, Set<District> distriсts) {
		this();
		this.name = name;
		this.distriсts = distriсts;
	}

	public Region(String name, Set<District> distriсts, City regionCenter) {
		this();
		this.name = name;
		this.distriсts = distriсts;
		this.regionCenter = regionCenter;
	}

	public void addDistrictToRegion(District district) {
		distriсts.add(district);
	}

	public void remoteDistrictFromRegion(District district) {
		distriсts.remove(district);
	}
	
	public double getArea() {
		double fullArea = 0;
		for(District district : distriсts) {
			fullArea += district.getArea();
		}
		return fullArea;
	}

	public int getPopulationSize() {
		int fullPopulationSize = 0;
		for (District district : distriсts) {
			fullPopulationSize += district.getPopulationSize();
		}
		return fullPopulationSize;
	}
	
	public String getName() {
		return name;
	}

	public Set<District> getDistriсts() {
		return distriсts;
	}

	public City getRegionCenter() {
		return regionCenter;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDistriсts(Set<District> distriсts) {
		this.distriсts = distriсts;
	}

	public void setRegionCenter(City regionCenter) {
		this.regionCenter = regionCenter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distriсts == null) ? 0 : distriсts.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regionCenter == null) ? 0 : regionCenter.hashCode());
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
		Region other = (Region) obj;
		if (distriсts == null) {
			if (other.distriсts != null)
				return false;
		} else if (!distriсts.equals(other.distriсts))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (regionCenter == null) {
			if (other.regionCenter != null)
				return false;
		} else if (!regionCenter.equals(other.regionCenter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", distriсts=" + distriсts + ", regionCenter="
				+ regionCenter + "]";
	}

}
