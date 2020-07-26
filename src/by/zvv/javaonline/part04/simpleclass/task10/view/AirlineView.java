package by.zvv.javaonline.part04.simpleclass.task10.view;

import java.util.List;

import by.zvv.javaonline.part04.simpleclass.task10.entity.Airline;

public class AirlineView {

	public void print(Airline air) {
		System.out.printf("%-12s%-5d%-12s%02d:%02d%11s\n", air.getDestination(), air.getNumber(), air.getType(),
				air.getDepartureTime().getHours(), air.getDepartureTime().getMinutes(), air.getDay());
	}
	
	public void printAll(List<Airline> airlines) {
		for (Airline a : airlines) {
			print(a);
		}
	}

}
