package by.zvv.javaonline.part04.simpleclass.task08.view;

import java.util.List;

import by.zvv.javaonline.part04.simpleclass.task08.entity.Customer;

public class CustomerView {

	public void print(Customer customer) {
		StringBuilder sb = new StringBuilder();
		String name;
		name = sb.append(customer.getSurname()).append(" ").append(customer.getFirstName()).append(" ")
				.append(customer.getSecondName()).toString();
		System.out.printf("id=%2d, %-28s %-10s creditCardNumber=%-20d bankAccountNumber=%-20d\n", customer.getId(),
				name, customer.getAddress(), customer.getCreditCardNumber(), customer.getBankAccountNumber());
	}

	public void printAll(List<Customer> customers) {
		for (Customer c : customers) {
			print(c);
		}
	}
}
