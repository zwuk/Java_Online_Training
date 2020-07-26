package by.zvv.javaonline.part04.aggregation.task02.view;

import java.util.Map;

import by.zvv.javaonline.part04.aggregation.task02.entity.Car;
import by.zvv.javaonline.part04.aggregation.task02.entity.Wheel;
import by.zvv.javaonline.part04.aggregation.task02.enums.Wheels;

public class CarView {

	public void showInfoAboutCar(Car car) {
		System.out.println(car.getName());
		System.out.print("Параметры двигателя: объем = " + car.getEngine().getCapacity() + " л.");
		System.out.print(", мощность = " + car.getEngine().getPower() + " л.с.");
		System.out.println(", расход топлива на 100 км. = " + car.getEngine().getAverageFuelConsumption() + " л.");
		System.out.print("Комплект колес: диаметр = ");
		System.out.print(car.getWheels().get(Wheels.BackLeft).getDiameter());
		System.out.println(", сезонность = " + car.getWheels().get(Wheels.BackLeft).getSeason());	
	}

	public void showInfoAboutCarWheels(Car car) {
		System.out.println("В автомобиле " + car.getName() + " используются:");
		for (Map.Entry<Wheels, Wheel> entry : car.getWheels().entrySet()) {
			showWheel(car, entry.getKey());
		}
	}

	public void showWheel(Car car, Wheels wheel) {
		StringBuilder sb = new StringBuilder();

		sb.append("Колесо ");
		sb.append(wheel);
		sb.append(" диаметр = ");
		sb.append(car.getWheels().get(wheel).getDiameter());
		sb.append(", сезонность = ");
		sb.append(car.getWheels().get(wheel).getSeason());
		System.out.println(sb.toString());
	}

}
