package by.zvv.javaonline.part04.aggregation.task04.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import by.zvv.javaonline.part04.aggregation.task04.entity.Account;
import by.zvv.javaonline.part04.aggregation.task04.entity.Accounts;
import by.zvv.javaonline.part04.aggregation.task04.entity.Client;
import by.zvv.javaonline.part04.aggregation.task04.view.AccountView;
import by.zvv.javaonline.part04.aggregation.task04.view.ClientView;

/* Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета. 
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. 
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class BankAccountsLogic {
	Random random = new Random();
	ClientLogic cl = new ClientLogic();
	ClientView cv = new ClientView();
	AccountLogic al = new AccountLogic();
	AccountView av = new AccountView();

	public Accounts init(Accounts a, int clientNumber, int accountNumber) {
		Client[] clients = new Client[clientNumber];
		Account[] accounts = new Account[accountNumber];

		for (int i = 0; i < clients.length; i++) {
			clients[i] = cl.initClient();
		}

		for (int j = 0; j < accounts.length; j++) {
			accounts[j] = al.initAccount(clients[random.nextInt(clients.length)]);
			a.addAccountToList(accounts[j]);
		}
		return a;
	}

	public List<Account> sortAccountByNumber(Accounts accounts) {
		List<Account> sortedList = new ArrayList<Account>(accounts.getAccounts());
		Comparator<Account> comp = Comparator.comparing(obj -> obj.getAccountNumber());

		sortedList.sort(comp);
		return sortedList;
	}
	
	public List<Account> sortAccountByNumberWithinBank(Accounts accounts) {
		List<Account> sortedList = new ArrayList<Account>(accounts.getAccounts());
//		Comparator<Account> comp = Comparator.comparing(o -> o.getBank());
//		comp = comp.thenComparing(o -> o.getAccountNumber());
		Comparator<Account> comp = (x1, x2) -> x1.getBank().compareTo(x2.getBank());
		comp = comp.thenComparing((x1, x2) -> (int) (x1.getAccountNumber() - x2.getAccountNumber()));

		sortedList.sort(comp);
		return sortedList;
	}
	
	public List<Account> getAllAccounts(Accounts accounts){
		List<Account> list = new ArrayList<Account>(accounts.getAccounts());
		return list;
	}

	public List<Account> getAllNotActiveAccount(Accounts accounts) {
		List<Account> list = new ArrayList<Account>(accounts.getAccounts());
		list = list.stream().filter(s -> s.isActive() == false).collect(Collectors.toList());
		return list;
	}

	public List<Client> getAllClients(Accounts accounts) {
		List<Account> list = new ArrayList<Account>(accounts.getAccounts());
		List<Client> clients = list.stream().map(s -> s.getClient()).distinct().collect(Collectors.toList());
		return clients;
	}

	public double getSumOfAllAccounts(Accounts accounts) {
		double sum = 0;
		List<Account> list = new ArrayList<Account>(accounts.getAccounts());
		sum = list.stream().mapToDouble(x -> x.getAmount()).sum();
		return sum;
	}

	public double getSumOfAccountList(List<Account> accounts) {
		return accounts.stream().mapToDouble(x -> x.getAmount()).sum();
	}

	public List<Account> getPositiveAccounts(Accounts accounts) {
		List<Account> list = new ArrayList<Account>(accounts.getAccounts());
		list = list.stream().filter(x -> x.getAmount() > 0).collect(Collectors.toList());
		return list;
	}

	public List<Account> getNegativeAccounts(Accounts accounts) {
		List<Account> list = new ArrayList<Account>(accounts.getAccounts());
		list = list.stream().filter(x -> x.getAmount() < 0).collect(Collectors.toList());
		return list;
	}

}
