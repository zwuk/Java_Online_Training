package by.zvv.javaonline.part04.aggregation.task04.logic;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import by.zvv.javaonline.part04.aggregation.task04.entity.Account;
import by.zvv.javaonline.part04.aggregation.task04.entity.Client;
import by.zvv.javaonline.part04.aggregation.task04.enums.Bank;

public class AccountLogic {
	Random rand = new Random();

	public Account initAccount(Client client) {
		Bank[] banks = Bank.values();
		Account account = new Account(client);
		account.setBank(banks[rand.nextInt(banks.length)]);
		account.setAccountNumber(10000000000L + rand.nextInt(100000));
		account.setActive(rand.nextBoolean());
		account.setAmount(rand.nextInt() % 100000);
		client.addAccount(account);
		return account;
	}

	public void topUpAccount(Account account, double amount) {
		double currentAmount = account.getAmount();
		if (account.isActive()) {
			currentAmount += amount;
			account.setAmount(currentAmount);
			System.out.println("Счет " + account.getAccountNumber() + " увеличен на сумму: " + amount);
		} else {
			System.out.println("Пополнение не возможно! Счет " + account.getAccountNumber() + " заблокирован");
		}
	}

	public void withdrawFromAccount(Account account, double amount) {
		double currentAmount = account.getAmount();
		if (account.isActive() && currentAmount > 0) {
			currentAmount -= amount;
			account.setAmount(currentAmount);
			System.out.println("Со счета " + account.getAccountNumber() + " снята сумма: " + amount);
		} else {
			System.out.println("Снятие денег не возможно! Счет " + account.getAccountNumber()
					+ " заблокирован или имеет отрицательный балланс.");
		}
	}

	public List<Account> sortAccountsByNumber(List<Account> accounts) {
		Comparator<Account> comp = Comparator.comparing(o -> o.getAccountNumber());
		accounts.sort(comp);
		return accounts;
	}

	public Account findAccount(List<Account> accounts, long accountNumber) {
		return accounts.stream().filter(x -> x.getAccountNumber() == accountNumber).findFirst().orElse(null);
	}
}
