package by.zvv.javaonline.part04.aggregation.task04.view;

import java.util.ArrayList;
import java.util.List;

import by.zvv.javaonline.part04.aggregation.task04.bean.Account;
import by.zvv.javaonline.part04.aggregation.task04.bean.Client;
import by.zvv.javaonline.part04.aggregation.task04.logic.CheckAction;
import by.zvv.javaonline.part04.aggregation.task04.logic.GetAction;
import by.zvv.javaonline.part04.aggregation.task04.logic.TransferAction;

public class ReportAction {

	public void printAccounts(String str, List<Account> accountList) {
		System.out.println(str);
		for (Account a : accountList) {
			print(a);
		}
	}

	public void printClients(String str, List<Client> clients) {
		System.out.println(str);
		for (Client c : clients) {
			print(c);
			System.out.println();
		}
	}

	public void print(Client c) {
		List<Account> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String name;
		name = sb.append(c.getSurname()).append(" ").append(c.getFirstName()).append(" ").append(c.getSecondName())
				.toString();
		System.out.printf("id=%2d, %-28s %-10s\n", c.getId(), name, c.getAddress());
		System.out.println("Счета:");
		list = c.getAccountNumbers();
		for (Account a : list) {
			System.out.printf("Bank: %-12s accountNumber=%d activ=%5b amount=%10.2f\n", a.getBank(),
					a.getAccountNumber(), a.isActive(), a.getAmount());
		}
	}

	public void print(Account a) {
		if (a != null) {
			StringBuilder sb = new StringBuilder();
			String name;

			name = sb.append(a.getClient().getSurname()).append(" ").append(a.getClient().getFirstName()).append(" ")
					.append(a.getClient().getSecondName()).toString();
			System.out.printf("%d Bank:%-12s активный:%-5b баланс=%10.2f Client:%-28s\n", a.getAccountNumber(),
					a.getBank(), a.isActive(), a.getAmount(), name);
		} else {
			System.out.println("данного счета нет в списке доступных!");
		}
	}

	public void printResultTopUp(boolean result, Account account, TransferAction action) {
		if (result) {
			System.out.println(
					"Счет " + account.getAccountNumber() + " увеличен на сумму: " + action.getTransactionAmount());
		} else {
			System.out.println("Пополнение невозможно! Счет " + account.getAccountNumber() + " заблокирован");
		}
	}

	public void printResultWithdraw(boolean result, Account account, TransferAction action) {
		if (result) {
			System.out.println(
					"Со счета " + account.getAccountNumber() + " снята сумма: " + action.getTransactionAmount());
		} else {
			System.out.println("Снятие денег невозможно! Счет " + account.getAccountNumber()
					+ " заблокирован или имеет отрицательный балланс.");
		}
	}

	public void printResultTransfer(boolean result, Account from, Account to, TransferAction action) {
		if (result) {
			System.out.println("Перевод суммы " + action.getTransactionAmount() + " со счета:" + from.getAccountNumber()
					+ " на счет: " + to.getAccountNumber() + " прошел успешно.");
			printCommission(from, to, action.getPercentage(), action.getTransactionAmount(), action.withdrawCommission());

		} else {
			System.out.println("Перевод невозможен! Один из счетов заблокирован или недостаточно средств.");
		}
	}

	public void printSumsAccountsAllClient(String str, List<Client> clients) {
		GetAction gAction = new GetAction();

		System.out.println(str);
		for (Client c : clients) {
			StringBuilder sb = new StringBuilder();
			String name;
			name = sb.append(c.getSurname()).append(" ").append(c.getFirstName()).append(" ").append(c.getSecondName())
					.toString();
			System.out.println("id=" + c.getId() + " " + name + ": " + gAction.getSumAllClientAccounts(c));
		}
	}

	public void printBalance(String str, double amount) {
		System.out.println(str + amount);
	}

	private void printCommission(Account a1, Account a2, double percentage, double amount, double commissionAmount) {
		CheckAction check = new CheckAction();
		if (!check.isWithinBank(a1, a2)) {
			System.out.println("Комиссия а размере " + percentage + " процентов от суммы " + amount + " составила "
					+ commissionAmount);
		} else {
			System.out.println("Комиссия не взималась.");
		}
	}
}
