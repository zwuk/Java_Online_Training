package by.zvv.javaonline.part04.aggregation.task02.entity;

public class Engine {
	private double capacity; // Объем
	private int power; // Мощность (лошадиные силы)
	private double averageFuelConsumption; // Расход топлива на 100 км.

	public Engine() {
		capacity = 1.6;
		power = 123;
		averageFuelConsumption = 8.5;
	}

	public Engine(double capacity, int power, double fuelConsumption) {
		this.capacity = capacity;
		this.power = power;
		this.averageFuelConsumption = fuelConsumption;
	}

	public double getCapacity() {
		return capacity;
	}

	public int getPower() {
		return power;
	}

	public double getAverageFuelConsumption() {
		return averageFuelConsumption;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageFuelConsumption);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(capacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + power;
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
		Engine other = (Engine) obj;
		if (Double.doubleToLongBits(averageFuelConsumption) != Double.doubleToLongBits(other.averageFuelConsumption))
			return false;
		if (Double.doubleToLongBits(capacity) != Double.doubleToLongBits(other.capacity))
			return false;
		if (power != other.power)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [capacity=" + capacity + ", power=" + power + ", averageFuelConsumption="
				+ averageFuelConsumption + "]";
	}

}
