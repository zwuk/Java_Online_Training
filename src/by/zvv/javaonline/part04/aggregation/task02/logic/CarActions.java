package by.zvv.javaonline.part04.aggregation.task02.logic;

import java.util.Map;

import by.zvv.javaonline.part04.aggregation.task02.entity.Car;
import by.zvv.javaonline.part04.aggregation.task02.entity.Wheel;
import by.zvv.javaonline.part04.aggregation.task02.enums.Wheels;

public class CarActions {
	
	private double checkDistance(Car car) {
		return car.getPetrolResidue() * 100 / car.getEngine().getAverageFuelConsumption();
	}
	
	public void drive(Car car) {
		System.out.printf("Поехали. Топлива в баке хватило на %.2f километров. Бак пуст!!!\n", checkDistance(car));
		car.setPetrolResidue(0);
	}

	public void drive(Car car, double distance) {
		double petrolResidue = car.getPetrolResidue();
		
		System.out.print("Поехали. ");
		if (checkDistance(car) < distance) {
			System.out.printf("Топлива в баке хватило на %.0f километров. Бак пуст!!!\n", checkDistance(car));
			car.setPetrolResidue(0);
		} else {
			petrolResidue -= car.getEngine().getAverageFuelConsumption() * distance / 100;
			System.out.printf("После преодоления %.0f километров в баке осталось %.2f литров топлива\n", distance,
					petrolResidue);
			car.setPetrolResidue(petrolResidue);
		}
	}
	
	public void fuelUp(Car car, int petrol) {
		double petrolResidue = car.getPetrolResidue();
		int fuelTankCapacity = car.getFuelTankCapacity();
		
		if (petrol + petrolResidue > fuelTankCapacity) {
			double temp = fuelTankCapacity - petrolResidue;
			car.setPetrolResidue(fuelTankCapacity);
			System.out.println("Бак полный. Объем залитого топлива = " + temp + " литров");
		} else {
			petrolResidue += petrol;
			System.out.println("Объем топлива в баке после заправки = " + petrolResidue + " литров");
			car.setPetrolResidue(petrolResidue);
		}
	}
	
	public void replaceWheel(Car car, Wheel w, Wheels wheel) {
		if (w.equals(car.getWheels().get(wheel))) {
			System.out.println("Тип колеса "  + wheel + " совпадает c устанавливаемым, меняем колесо");
			car.getWheels().put(wheel, w);
		} else {
			System.out.println("Тип колеса " + wheel + " не совпадает c устанавливаемым, меняем весь комплект колес");
			replaceAllWheels(car, w);
		}
	}

	public void replaceAllWheels(Car car, Wheel w) {
		for (Map.Entry<Wheels, Wheel> entry : car.getWheels().entrySet()) {
			entry.setValue(w);
		}
	}
}
