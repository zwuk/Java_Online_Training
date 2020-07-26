package by.zvv.javaonline.part04.simpleclass.task08.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import by.zvv.javaonline.part04.simpleclass.task08.entity.Customer;

public class CustomerLogic {

	public void initList(List<Customer> customers, int size) {
		Random rand = new Random();
		String[] surnames = { "Иванов", "Петров", "Сидоров", "Потапов", "Мустафаев", "Романов", "Егоров", "Астапов",
				"Львов", "Смирнов" };
		String[] firstNames = { "Иван", "Петр", "Сидор", "Потап", "Мустафа", "Роман", "Егор", "Остап", "Лев",
				"Еремей" };
		String[] secondNames = { "Иванович", "Петрович", "Сидорович", "Потапович", "Мустафаевич", "Романович",
				"Егорович", "Остапович", "Львович", "Еремеевич" };

		for (int i = 0; i < size; i++) {
			String surname = surnames[rand.nextInt(surnames.length)];
			String firstName = firstNames[rand.nextInt(firstNames.length)];
			String secondName = secondNames[rand.nextInt(secondNames.length)];
			Customer customer = new Customer(surname, firstName, secondName);
			customer.setAddress("address_" + rand.nextInt(100));
			customer.setCreditCardNumber(Math.abs(rand.nextLong()));
			customer.setBankAccountNumber(Math.abs(rand.nextLong()));
			customers.add(customer);
		}
	}

	public List<Customer> sortByAlphabet(List<Customer> customers) {
		List<Customer> sortedCustomers = new ArrayList<Customer>();
		sortedCustomers.addAll(customers);
		Comparator<Customer> comp = Comparator.comparing(obj -> obj.getSurname().toUpperCase());
		comp = comp.thenComparing(obj -> obj.getSecondName().toUpperCase());
		comp = comp.thenComparing(obj -> obj.getSecondName().toUpperCase());

		sortedCustomers.sort(comp);
		return sortedCustomers;
	}

	public List<Customer> getCustomersByCreditCardDiapason(List<Customer> customers, long start, long end) {
		List<Customer> selectedCustomers = new ArrayList<Customer>();
		selectedCustomers = customers.stream().filter(x -> x.getCreditCardNumber() > start && x.getCreditCardNumber() < end)
				.collect(Collectors.toList());
		return selectedCustomers;
	}
}
