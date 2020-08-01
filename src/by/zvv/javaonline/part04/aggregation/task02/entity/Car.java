package by.zvv.javaonline.part04.aggregation.task02.entity;

import java.util.HashMap;
import java.util.Map;

import by.zvv.javaonline.part04.aggregation.task02.enums.Season;
import by.zvv.javaonline.part04.aggregation.task02.enums.Wheels;

public class Car {
	private Map<Wheels, Wheel> wheels = new HashMap<Wheels, Wheel>();
	private Engine engine = new Engine();
	private String name; 				// Марка автомобиля
	private int fuelTankCapacity; 		// Емкость бензобака
	private double petrolResidue = 0;	// Остаток топлива в баке

	public Car() {	
		wheels.put(Wheels.FRONTLEFT, new Wheel(Season.SUMMER, 15));
		wheels.put(Wheels.FRONTRIGHT, new Wheel(Season.SUMMER, 15));
		wheels.put(Wheels.BACKLEFT, new Wheel(Season.SUMMER, 15));
		wheels.put(Wheels.BACKRIGHT, new Wheel(Season.SUMMER, 15));
		engine = new Engine();
		name = "Hyundai Solaris";
		fuelTankCapacity = 45;
		petrolResidue = 0;
	}

	public Car(Wheel wheel, Engine engine, String name, int fuelTankCapacity) {
		wheels.put(Wheels.FRONTLEFT, wheel);
		wheels.put(Wheels.FRONTRIGHT, wheel);
		wheels.put(Wheels.BACKLEFT, wheel);
		wheels.put(Wheels.BACKRIGHT, wheel);
		this.engine = engine;
		this.name = name;
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public Engine getEngine() {
		return engine;
	}

	public String getName() {
		return name;
	}

	public int getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public double getPetrolResidue() {
		return petrolResidue;
	}

	public Map<Wheels, Wheel> getWheels() {
		return wheels;
	}

	public void setPetrolResidue(double petrolResidue) {
		this.petrolResidue = petrolResidue;
	}

}
