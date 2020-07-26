package by.zvv.javaonline.part04.aggregation.task04.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import by.zvv.javaonline.part04.aggregation.task04.entity.Account;
import by.zvv.javaonline.part04.aggregation.task04.entity.Client;

public class ClientLogic {
	Random rand = new Random();

	public Client initClient() {
		Client client;
		String[] surnames = { "Иванов", "Петров", "Сидоров", "Потапов", "Мустафаев", "Романов", "Егоров", "Астапов",
				"Львов", "Смирнов", "Яковлев" };
		String[] firstNames = { "Иван", "Петр", "Сидор", "Потап", "Мустафа", "Роман", "Егор", "Остап", "Лев",
				"Еремей", "Яков"  };
		String[] secondNames = { "Иванович", "Петрович", "Сидорович", "Потапович", "Мустафаевич", "Романович",
				"Егорович", "Остапович", "Львович", "Еремеевич", "Якович"  };

		String surname = surnames[rand.nextInt(surnames.length)];
		String firstName = firstNames[rand.nextInt(firstNames.length)];
		String secondName = secondNames[rand.nextInt(secondNames.length)];
		client = new Client(surname, firstName, secondName);
		client.setAddress("address_" + rand.nextInt(100));

		return client;
	}

	public double getSumAllClientAccounts(Client client) {
//		double sum = 0;
		List<Account> list = new ArrayList<>();
		list = client.getAccountNumbers();
//		for (Account a : list) {
//			sum += a.getAmount();
//		}
//		return sum;
		return list.stream().mapToDouble(x -> x.getAmount()).sum();
	}
	
	public List<Client> sortClientsById(List<Client> clients){
		Comparator<Client> comp = Comparator.comparing(o -> o.getId());	
		clients.sort(comp);
		return clients;
	}
	
	public List<Client> sortClientsByFullName(List<Client> clients){
		Comparator<Client> comp = Comparator.comparing(o -> o.getSurname());
		comp = comp.thenComparing(o -> o.getFirstName()).thenComparing(o -> o.getSecondName());
		clients.sort(comp);
		return clients;
	} 
}
