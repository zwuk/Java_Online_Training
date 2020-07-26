package by.zvv.javaonline.part04.aggregation.task04.view;

import java.util.ArrayList;
import java.util.List;

import by.zvv.javaonline.part04.aggregation.task04.entity.Account;
import by.zvv.javaonline.part04.aggregation.task04.entity.Client;

public class ClientView {

	public void print(Client client) {
		List<Account> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String name;
		name = sb.append(client.getSurname()).append(" ").append(client.getFirstName()).append(" ")
				.append(client.getSecondName()).toString();
		System.out.printf("id=%2d, %-28s %-10s\n", client.getId(), name, client.getAddress());
		System.out.println("Счета:");
		list = client.getAccountNumbers();
		for (Account a : list) {
			System.out.printf("Bank: %-12s accountNumber=%d activ=%5b amount=%10.2f\n", a.getBank(),
					a.getAccountNumber(), a.isActive(), a.getAmount());
		}
	}

}
