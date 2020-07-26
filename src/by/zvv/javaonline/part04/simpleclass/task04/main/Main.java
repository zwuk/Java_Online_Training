package by.zvv.javaonline.part04.simpleclass.task04.main;

import by.zvv.javaonline.part04.simpleclass.task04.entity.Train;
import by.zvv.javaonline.part04.simpleclass.task04.entity.TrainSchedule;
import by.zvv.javaonline.part04.simpleclass.task04.logic.TrainLogic;
import by.zvv.javaonline.part04.simpleclass.task04.view.TrainView;

/* Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления. 
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов 
 * массива по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен 
 * пользователем. Добавьте возможность сортировки массива по пункту назначения, причем поезда 
 * с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */
public class Main {
	
	public static void main(String[] args) {
		TrainLogic tl = new TrainLogic();
		TrainView tv = new TrainView();
		int trainNumber;
		int numberOfTrainsInSchedule = 5;
		Train[] tSchedule = new Train[numberOfTrainsInSchedule];
		TrainSchedule depo = new TrainSchedule();
		
		// Вариант №1
		System.out.println("Вариант с использованием простого массива поездов");
		tl.initSchedule(tSchedule); // Генерация расписания поездов
		
		tv.print("Расписание поездов", tSchedule);
		
		trainNumber = tv.requestTrainNumber(tSchedule, "Введите номер поезда для получения информации о нем: ");
		tv.printInfoAboutTrainByNumber(trainNumber, tSchedule);	
		System.out.println();
		
		tv.print("Расписание поездов отсортированное по номеру поезда", tl.sortByNumber(tSchedule));
		System.out.println();
		
		tv.print("Расписание поездов отсортированное по направлению и времени отправления", tl.sortByDestinationAndDepartureTime(tSchedule));
		System.out.println();
		
		// Вариант №2
		System.out.println("Вариант с использованием массива ArrayList");
		tl.initSchedule(depo.getTrains(), numberOfTrainsInSchedule); // Генерация расписания поездов
		
		tv.print("Расписание поездов", depo.getTrains());
		
		trainNumber = tv.requestTrainNumber(depo.getTrains(), "Введите номер поезда для получения информации о нем: ");
		tv.printInfoAboutTrainByNumber(trainNumber, depo.getTrains());
		System.out.println();
		
		tv.print("Расписание поездов отсортированное по номеру поезда", tl.sortByNumber(depo.getTrains()));
		System.out.println();
		
		tv.print("Расписание поездов отсортированное по направлению и времени отправления", tl.sortByDestinationAndDepartureTime(depo.getTrains()));

	}
	
}
