package by.zvv.javaonline.part04.simpleclass.task04.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import by.zvv.javaonline.part04.simpleclass.task04.entity.MyTime;
import by.zvv.javaonline.part04.simpleclass.task04.entity.Train;

public class TrainLogic {

	private static final int MAX_TRAIN_NUMBER 	= 1000;
	private static final int SECONDS_IN_DAY 	= 86400;

	// Метод инициализации расписания поездов вариант №1
	public void initSchedule(Train[] trains) {
		Random random = new Random();
		String[] destination = { "Гомель", "Витебск", "Адлер", "Минск", "Гродно", "Могилев", "Калининград" };
		int[] trainNumbers = new int[MAX_TRAIN_NUMBER];

		// Инициализация массива
		for (int i = 0; i < trainNumbers.length; i++) {
			trainNumbers[i] = i + 1; // исключаем нулевое значение номера поезда
		}

		// Получение выборки номеров поездов массива trainNumbers
		for (int i = 0; i < trains.length; i++) {
			// trainNumbers[i] меняется со случайным элементом справа
			int tempIndex = i + random.nextInt(MAX_TRAIN_NUMBER - i);
			int temp = trainNumbers[i];
			trainNumbers[i] = trainNumbers[tempIndex];
			trainNumbers[tempIndex] = temp;
		}

		for (int i = 0; i < trains.length; i++) {
			trains[i] = new Train(destination[random.nextInt(destination.length)], trainNumbers[i],
					new MyTime(random.nextInt(SECONDS_IN_DAY)));
		}
	}

	// Метод инициализации расписания поездов вариант №2
	public void initSchedule2(Train[] trains) {
		Random random = new Random();
		String[] destination = { "Гомель", "Витебск", "Адлер", "Минск", "Гродно", "Могилев", "Калининград" };
		int[] trainNumbers;

		Supplier<Integer> rand = () -> new Random().nextInt(MAX_TRAIN_NUMBER);
		trainNumbers = Stream.generate(rand).mapToInt(x -> x + 1).distinct().limit(trains.length).toArray();

		for (int i = 0; i < trains.length; i++) {
			trains[i] = new Train(destination[random.nextInt(destination.length)], trainNumbers[i],
					new MyTime(random.nextInt(SECONDS_IN_DAY)));
		}
	}

	// Метод инициализации расписания поездов
	public void initSchedule(List<Train> trains, int size) {
		Random random = new Random();
		String[] destination = { "Гомель", "Витебск", "Адлер", "Минск", "Гродно", "Могилев", "Калининград" };
		int[] trainNumbers;

		Supplier<Integer> rand = () -> new Random().nextInt(MAX_TRAIN_NUMBER);
		trainNumbers = Stream.generate(rand).mapToInt(x -> x + 1).distinct().limit(size).toArray();

		for (int i = 0; i < size; i++) {
			trains.add(new Train(destination[random.nextInt(destination.length)], trainNumbers[i],
					new MyTime(random.nextInt(SECONDS_IN_DAY))));
		}
	}

	// Получение информации о поезде по номеру
	public Train getInfoAboutTrainByNumber(int num, Train[] trains) {
		for (Train t : trains) {
			if (num == t.getNumber()) {
				return t;
			}
		}
		return null;
	}

	public Train getInfoAboutTrainByNumber(int num, List<Train> trains) {
		for (Train t : trains) {
			if (num == t.getNumber()) {
				return t;
			}
		}
		return null;
	}

	public Train[] sortByNumber(Train[] trains) {
		Train[] sortedTrains = new Train[trains.length];
		Train temp;

		System.arraycopy(trains, 0, sortedTrains, 0, trains.length);
		for (int j = sortedTrains.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (sortedTrains[i].getNumber() > sortedTrains[i + 1].getNumber()) {
					temp = sortedTrains[i];
					sortedTrains[i] = sortedTrains[i + 1];
					sortedTrains[i + 1] = temp;
				}
			}
		}
		return sortedTrains;
	}

	public List<Train> sortByNumber(List<Train> trains) {
		List<Train> sortedTrains = new ArrayList<Train>();
		Train temp;
		sortedTrains.addAll(trains);
		for (int j = sortedTrains.size() - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (sortedTrains.get(i).getNumber() > sortedTrains.get(i + 1).getNumber()) {
					temp = sortedTrains.get(i);
					sortedTrains.set(i, sortedTrains.get(i + 1));
					sortedTrains.set(i + 1, temp);
				}
			}
		}
		return sortedTrains;
	}

	public Train[] sortByDestination(Train[] trains) {
		Train[] sortedTrains = new Train[trains.length];
		Train temp;

		System.arraycopy(trains, 0, sortedTrains, 0, trains.length);
		for (int j = sortedTrains.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (sortedTrains[i].getDestination().compareTo(sortedTrains[i + 1].getDestination()) > 0) {
					temp = sortedTrains[i];
					sortedTrains[i] = sortedTrains[i + 1];
					sortedTrains[i + 1] = temp;
				}
			}
		}
		return sortedTrains;
	}

	public List<Train> sortByDestination(List<Train> trains) {
		List<Train> sortedTrains = new ArrayList<Train>();
		Train temp;
		sortedTrains.addAll(trains);
		for (int j = sortedTrains.size() - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (sortedTrains.get(i).getDestination().compareTo(sortedTrains.get(i + 1).getDestination()) > 0) {
					temp = sortedTrains.get(i);
					sortedTrains.set(i, sortedTrains.get(i + 1));
					sortedTrains.set(i + 1, temp);
				}
			}
		}
		return sortedTrains;
	}

	public Train[] sortByDestinationAndDepartureTime(Train[] trains) {
		Train[] sortedTrains = new Train[trains.length];
		Train temp;

		int length = 1;
		int index = 0;
		int x = index;

		System.arraycopy(sortByDestination(trains), 0, sortedTrains, 0, trains.length);
		
		do {
			while (index < sortedTrains.length - 1
					&& sortedTrains[index].getDestination().compareTo(sortedTrains[index + 1].getDestination()) == 0) {
				length++;
				index++;
			}
			if (length > 1) {
				for (int j = length - 1; j > 0; j--) {
					for (int i = x; i < j + x; i++) {
						if (sortedTrains[i].getDepartureTime().getTimeInSeconds() > sortedTrains[i + 1]
								.getDepartureTime().getTimeInSeconds()) {
							temp = sortedTrains[i];
							sortedTrains[i] = sortedTrains[i + 1];
							sortedTrains[i + 1] = temp;
						}
					}
				}
			}
			length = 1;
			index++;
			x = index;
		} while (index < sortedTrains.length - 1);
		return sortedTrains;
	}

	public List<Train> sortByDestinationAndDepartureTime(List<Train> trains) {
		List<Train> sortedTrains = new ArrayList<Train>();
		Train temp;
		int length = 1;
		int index = 0;
		int x = index;

		sortedTrains.addAll(sortByDestination(trains));

		do {
			while (index < sortedTrains.size() - 1 && sortedTrains.get(index).getDestination()
					.compareTo(sortedTrains.get(index + 1).getDestination()) == 0) {
				length++;
				index++;
			}
			if (length > 1) {
				for (int j = length - 1; j > 0; j--) {
					for (int i = x; i < j + x; i++) {
						if (sortedTrains.get(i).getDepartureTime().getTimeInSeconds() > sortedTrains.get(i + 1)
								.getDepartureTime().getTimeInSeconds()) {
							temp = sortedTrains.get(i);
							sortedTrains.set(i, sortedTrains.get(i + 1));
							sortedTrains.set(i + 1, temp);
						}
					}
				}
			}
			length = 1;
			index++;
			x = index;
		} while (index < sortedTrains.size() - 1);
		return sortedTrains;
	}

}
