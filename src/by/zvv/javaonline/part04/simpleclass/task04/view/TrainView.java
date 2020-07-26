package by.zvv.javaonline.part04.simpleclass.task04.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import by.zvv.javaonline.part04.simpleclass.task04.entity.Train;
import by.zvv.javaonline.part04.simpleclass.task04.logic.TrainLogic;

public class TrainView {

	TrainLogic tl = new TrainLogic();

	// Метод вывода на консоль расписания поездов
	public void print(String str, Train[] trains) {
		System.out.println(str);
		System.out.printf("%-9s%-13s%-20s\n", "№ поезда", "Направление", "Время отправления");
		System.out.println("---------------------------------------");
		for (Train t : trains) {
			print(t);
		}
	}

	// Метод вывода на консоль расписания поездов
	public void print(String str, List<Train> trains) {
		System.out.println(str);
		System.out.printf("%-9s%-13s%-20s\n", "№ поезда", "Направление", "Время отправления");
		System.out.println("---------------------------------------");
		for (Train t : trains) {
			print(t);
		}
	}

	// Метод вывода информации о поезде
	public void print(Train train) {
		System.out.printf("%-9d%-13s%02d:%02d\n", train.getNumber(), train.getDestination(),
				train.getDepartureTime().getHours(), train.getDepartureTime().getMinutes());
	}

	// Метод вывода информации о поезде по номеру
	public void printInfoAboutTrainByNumber(int num, Train[] trains) {
		Train train;
		train = tl.getInfoAboutTrainByNumber(num, trains);
		if (train != null) {
			System.out.printf("%-9s%-13s%-20s\n", "№ поезда", "Направление", "Время отправления");
			print(train);
		} else {
			System.out.println("Поезд с номером " + num + " отсутствует в расписании");
		}
	}

	// Метод вывода информации о поезде по номеру
	public void printInfoAboutTrainByNumber(int num, List<Train> trains) {
		Train train;
		train = tl.getInfoAboutTrainByNumber(num, trains);
		if (train != null) {
			System.out.printf("%-9s%-13s%-20s\n", "№ поезда", "Направление", "Время отправления");
			print(train);
		} else {
			System.out.println("Поезд с номером " + num + " отсутствует в расписании");
		}
	}

	public void showListOfTrainNumber(Train[] trains) {
		System.out.print("\nСписок доступных поездов "
				+ Arrays.stream(trains).map(n -> n.getNumber()).sorted().collect(Collectors.toList()) + ": ");
	}

	public void showListOfTrainNumber(List<Train> trains) {
		System.out.print("\nСписок доступных поездов "
				+ trains.stream().map(n -> n.getNumber()).sorted().collect(Collectors.toList()) + ": ");
	}

	// Метод запроса номера в консоли
	public int requestTrainNumber(Train[] trains, String str) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(str);
		showListOfTrainNumber(trains);

		while (!sc.hasNextInt()) {
			System.out.print("Ошибка!!! " + str);
			sc.nextLine();
		}
		int number = sc.nextInt();
		sc.nextLine();
		return number;
	}
	
	// Метод запроса номера в консоли
		public int requestTrainNumber(List<Train> trains, String str) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			System.out.print(str);
			showListOfTrainNumber(trains);

			while (!sc.hasNextInt()) {
				System.out.print("Ошибка!!! " + str);
				sc.nextLine();
			}
			int number = sc.nextInt();
			sc.nextLine();
			return number;
		}
}
