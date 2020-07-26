package by.zvv.javaonline.part04.simpleclass.task10.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.zvv.javaonline.part04.simpleclass.task04.entity.MyTime;
import by.zvv.javaonline.part04.simpleclass.task10.entity.Airline;
import by.zvv.javaonline.part04.simpleclass.task10.entity.Airport;
import by.zvv.javaonline.part04.simpleclass.task10.enums.City;
import by.zvv.javaonline.part04.simpleclass.task10.enums.Day;
import by.zvv.javaonline.part04.simpleclass.task10.logic.AirlineLogic;
import by.zvv.javaonline.part04.simpleclass.task10.view.AirlineView;

/* Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString(). 
 * Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами. 
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */
public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		AirlineLogic al = new AirlineLogic();
		AirlineView av = new AirlineView();
		Airport airport = new Airport();
		List<Airline> list = new ArrayList<Airline>();
		int scheduleSize = 15;
		
		// Генерируем и печатаем расписание
		al.initSchedule(airport.getAirlines(), scheduleSize);
		av.printAll(airport.getAirlines());
		System.out.println();
		
//		City destCity = City.Barcelona;
		City destCity = City.values()[random.nextInt(City.values().length)]; // Место назначения - случайным образом из списка доступных
		System.out.println("Available flights to " + destCity);	
		list = al.getAiplinesByDestination(airport.getAirlines(), destCity);
		av.printAll(list);

		System.out.println();
		
//		Day day = Day.SUNDAY;
		Day day = Day.values()[random.nextInt(Day.values().length)]; 
		System.out.println("Available flights on " + day);
		list = al.getAiplinesByDay(airport.getAirlines(), day);
		av.printAll(list);
		System.out.println();
		
		MyTime time = new MyTime(12, 00);
//		day = Day.THURSDAY;
//		MyTime time = new MyTime(random.nextInt(MyTime.SECONDS_IN_DAY));
		day = Day.values()[random.nextInt(Day.values().length)]; 
		System.out.printf("Available flights on %s after %02d:%02d\n", day, time.getHours(), time.getMinutes());
		list = al.getAiplinesByDayAfterTime(airport.getAirlines(), day, time);
		av.printAll(list);
	}

}
