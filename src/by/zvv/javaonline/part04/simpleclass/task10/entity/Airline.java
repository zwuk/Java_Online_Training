package by.zvv.javaonline.part04.simpleclass.task10.entity;

import by.zvv.javaonline.part04.simpleclass.task04.entity.MyTime;
import by.zvv.javaonline.part04.simpleclass.task10.enums.Airplane;
import by.zvv.javaonline.part04.simpleclass.task10.enums.City;
import by.zvv.javaonline.part04.simpleclass.task10.enums.Day;

/* Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString(). 
 * Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами. 
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */
public class Airline {
	private City destination;
	private int number;
	private Airplane type;
	private MyTime departureTime;
	private Day day;
	
	{
		departureTime  = new MyTime(0);
	}

	public Airline(int number) {
		this.number = number;
	}

	public Airline(City destination) {
		this.destination = destination;
	}

	public Airline(City destination, int number) {
		this.destination = destination;
		this.number = number;
	}

	public Airline(City destination, int number, Airplane type, MyTime departureTime, Day day) {
		this.destination = destination;
		this.number = number;
		this.type = type;
		this.departureTime = departureTime;
		this.day = day;
	}

	public City getDestination() {
		return destination;
	}

	public int getNumber() {
		return number;
	}

	public Airplane getType() {
		return type;
	}

	public MyTime getDepartureTime() {
		return departureTime;
	}

	public Day getDay() {
		return day;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setType(Airplane type) {
		this.type = type;
	}

	public void setDepartureTime(MyTime departureTime) {
		this.departureTime = departureTime;
	}

	public void setDay(Day day) {
		this.day = day;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [destination=" + destination + ", number=" + number + ", type=" + type
				+ ", departureTime(seconds)=" + departureTime + ", day=" + day + "]";
	}

}
