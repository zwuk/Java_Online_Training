package by.zvv.javaonline.part04.aggregation.task03.entity;

import java.util.HashSet;
import java.util.Set;

public class Country {
	private String name;
	private Set<Region> regions;
	private City capital;

	public Country() {
		regions = new HashSet<Region>();
	}

	public Country(String name) {
		this();
		this.name = name;
	}

	public Country(String name, Set<Region> regions, City capital) {
		this();
		this.name = name;
		this.regions = regions;
		this.capital = capital;
	}

	public void addRegionToCountry(Region region) {
		regions.add(region);
	}

	public void remoteRegionFromCountry(Region region) {
		regions.remove(region);
	}
	
	public double getArea() {
		double fullArea = 0;
		for (Region region : regions) {
			fullArea += region.getArea();
		}
		return fullArea;
	}

	public int getPopulationSize() {
		int fullPopulationSize = 0;
		for (Region region : regions) {
			fullPopulationSize += region.getPopulationSize();
		}
		return fullPopulationSize;
	}

	public String getName() {
		return name;
	}

	public Set<Region> getRegions() {
		return regions;
	}

	public City getCapital() {
		return capital;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regions == null) ? 0 : regions.hashCode());
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
		Country other = (Country) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (regions == null) {
			if (other.regions != null)
				return false;
		} else if (!regions.equals(other.regions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", regions=" + regions + ", capital=" + capital + "]";
	}

}
