package by.zvv.javaonline.part04.aggregation.task04.view;

import java.util.List;

import by.zvv.javaonline.part04.aggregation.task04.entity.Account;
import by.zvv.javaonline.part04.aggregation.task04.entity.Client;
import by.zvv.javaonline.part04.aggregation.task04.logic.ClientLogic;

public class BankAccountsView {
	ClientLogic cl = new ClientLogic();
	ClientView cv = new ClientView();
	AccountView av = new AccountView();

	public void printSumsAccountsAllClient(List<Client> clients) {
		for (Client c : clients) {
			StringBuilder sb = new StringBuilder();
			String name;
			name = sb.append(c.getSurname()).append(" ").append(c.getFirstName()).append(" ").append(c.getSecondName())
					.toString();
			System.out.println("id=" + c.getId() + " " + name + ": " + cl.getSumAllClientAccounts(c));
		}
	}

	public void printAllAccounts(List<Account> accounts) {
		for (Account a : accounts) {
			av.print(a);
		}
	}

	public void printAllClients(List<Client> clients) {
		for (Client c : clients) {
			cv.print(c);
			System.out.println();
		}
	}
}
