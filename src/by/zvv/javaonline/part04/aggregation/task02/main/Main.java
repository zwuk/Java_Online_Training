package by.zvv.javaonline.part04.aggregation.task02.main;

import by.zvv.javaonline.part04.aggregation.task02.entity.Car;
import by.zvv.javaonline.part04.aggregation.task02.entity.Engine;
import by.zvv.javaonline.part04.aggregation.task02.entity.Wheel;
import by.zvv.javaonline.part04.aggregation.task02.enums.Season;
import by.zvv.javaonline.part04.aggregation.task02.enums.Wheels;
import by.zvv.javaonline.part04.aggregation.task02.logic.CarActions;
import by.zvv.javaonline.part04.aggregation.task02.view.CarView;

/* Создать объект класса Автомобиль, используя классы Колесо, Двигатель. 
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
 */
public class Main {

	public static void main(String[] args) {
		CarActions carAction = new CarActions();
		CarView carView = new CarView();

		Car car1 = new Car();
		Car car2 = new Car(new Wheel(Season.Winter, 18), new Engine(3.0, 270, 7.8), "Mercedes CLS 450", 60);
		
		System.out.println(car1.getName());
		carAction.fuelUp(car1, 35);
		carAction.drive(car1, 210);
		carAction.fuelUp(car1, 16);
		carAction.drive(car1, 500);
		
		System.out.println();

		carView.showInfoAboutCar(car2);
		carAction.replaceWheel(car2, new Wheel(Season.Winter, 18), Wheels.BackLeft);
		System.out.println();
		
		carAction.replaceWheel(car2, new Wheel(Season.Summer, 19), Wheels.FrontLeft);
		carView.showInfoAboutCarWheels(car2);
		carAction.drive(car2, 250);
		carAction.fuelUp(car2, 100);
		carAction.drive(car2, 250);
		carAction.drive(car2);
		
	}

}
