package by.zvv.javaonline.part04.aggregation.task04.logic;

import java.util.Random;

import by.zvv.javaonline.part04.aggregation.task04.bean.Account;
import by.zvv.javaonline.part04.aggregation.task04.bean.Accounts;
import by.zvv.javaonline.part04.aggregation.task04.bean.Client;
import by.zvv.javaonline.part04.aggregation.task04.enums.Bank;

public class InitAction {
	Random random = new Random();

	private Client initClient() {
		Client client;
		String[] surnames = { "Иванов", "Петров", "Сидоров", "Яковлев", "Павлов", "Мустафаев", "Артемов", "Львов",
				"Еремеев", "Семенов", "Борисов" };
		String[] firstNames = { "Иван", "Петр", "Сидор", "Яков", "Павел", "Мустафа", "Артем", "Лев", "Еремей", "Семен",
				"Борис" };
		String[] secondNames = { "Иванович", "Петрович", "Сидорович", "Яковлевич", "Павлович", "Мустафаевич",
				"Артемович", "Львович", "Еремеевич", "Семенович", "Борисович" };
		
		String surname = surnames[random.nextInt(surnames.length)];
		String firstName = firstNames[random.nextInt(firstNames.length)];
		String secondName = secondNames[random.nextInt(secondNames.length)];
		
		client = new Client(surname, firstName, secondName);
		client.setAddress("address_" + random.nextInt(100));
		
		return client;
	}
	
	private Account initAccount(Client client) {
		Bank[] banks = Bank.values();
		Account account = new Account(client);
		
		account.setBank(banks[random.nextInt(banks.length)]);
		account.setAccountNumber(10000000000L + random.nextInt(100000));
		account.setActive(random.nextBoolean());
		account.setAmount(random.nextInt() % 10000);
		client.addAccount(account);
		return account;
	}
	
	public Accounts init(Accounts a, int clientNumber, int accountNumber) {
		Client[] clients = new Client[clientNumber];
		Account[] accounts = new Account[accountNumber];
		
		for(int i = 0; i < clients.length; i++) {
			clients[i] = initClient();
		}
		for(int j = 0; j < accounts.length; j++) {
			accounts[j] = initAccount(clients[random.nextInt(clients.length)]);
			a.addAccount(accounts[j]);
		}
		return a;
	}
}
