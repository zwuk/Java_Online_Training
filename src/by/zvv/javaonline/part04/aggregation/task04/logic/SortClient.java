package by.zvv.javaonline.part04.aggregation.task04.logic;

import java.util.Comparator;
import java.util.List;

import by.zvv.javaonline.part04.aggregation.task04.bean.Client;

public class SortClient {

	public List<Client> byId(List<Client> clients) {
		Comparator<Client> comp = Comparator.comparing(o -> o.getId());
		clients.sort(comp);
		return clients;
	}

	public List<Client> byFullName(List<Client> clients) {
		Comparator<Client> comp = Comparator.comparing(o -> o.getSurname());
		comp = comp.thenComparing(o -> o.getFirstName()).thenComparing(o -> o.getSecondName());
		clients.sort(comp);
		return clients;
	}
}
