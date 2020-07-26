package by.zvv.javaonline.part04.simpleclass.task10.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import by.zvv.javaonline.part04.simpleclass.task04.entity.MyTime;
import by.zvv.javaonline.part04.simpleclass.task10.entity.Airline;
import by.zvv.javaonline.part04.simpleclass.task10.enums.Airplane;
import by.zvv.javaonline.part04.simpleclass.task10.enums.City;
import by.zvv.javaonline.part04.simpleclass.task10.enums.Day;

/* Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */
public class AirlineLogic {
	private static final int MAX_NUMBER_PLANE = 1000;

	public void initSchedule(List<Airline> airlines, int size) {
		Random random = new Random();
		Airplane[] planes = Airplane.values();
		Day[] days = Day.values();
		City[] dest = City.values();
		int[] airplaneNumber;

		Supplier<Integer> rand = () -> new Random().nextInt(MAX_NUMBER_PLANE);
		airplaneNumber = Stream.generate(rand).mapToInt(x -> x + 1).distinct().limit(size).toArray();

		for (int i = 0; i < size; i++) {
			airlines.add(new Airline(dest[random.nextInt(dest.length)], airplaneNumber[i],
					planes[random.nextInt(planes.length)], new MyTime(random.nextInt(MyTime.SECONDS_IN_DAY)),
					days[random.nextInt(days.length)]));
		}
	}

	public List<Airline> getAiplinesByDestination(List<Airline> airlines, City destination) {
		List<Airline> listByDestination = new ArrayList<Airline>();
		listByDestination = airlines.stream().filter(x -> x.getDestination().equals(destination))
				.collect(Collectors.toList());
		return listByDestination;
	}

	public List<Airline> getAiplinesByDay(List<Airline> airlines, Day day) {
		List<Airline> listByDay = new ArrayList<Airline>();
		listByDay = airlines.stream().filter(x -> x.getDay().equals(day)).collect(Collectors.toList());
		return listByDay;
	}

	public List<Airline> getAiplinesByDayAfterTime(List<Airline> airlines, Day day, MyTime time) {
		List<Airline> listByDayAfterTime = new ArrayList<Airline>();
		listByDayAfterTime = airlines.stream()
				.filter(x -> x.getDay().equals(day) && x.getDepartureTime().getTimeInSeconds() > time.getTimeInSeconds())
				.collect(Collectors.toList());
		return listByDayAfterTime;
	}
}
