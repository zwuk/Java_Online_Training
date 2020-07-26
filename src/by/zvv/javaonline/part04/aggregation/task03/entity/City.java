package by.zvv.javaonline.part04.aggregation.task03.entity;

public class City implements Comparable<City> {
	private String name;
	private int populationSize;
	
	public City(String name, int populationSize) {
		this.name = name;
		this.populationSize = populationSize;
	}

	public String getName() {
		return name;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", populationSize=" + populationSize + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + populationSize;
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
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (populationSize != other.populationSize)
			return false;
		return true;
	}

	@Override
	public int compareTo(City o) {
		return this.name.compareTo(o.name);
//		return this.populationSize - o.populationSize;
	}
	
	

}
