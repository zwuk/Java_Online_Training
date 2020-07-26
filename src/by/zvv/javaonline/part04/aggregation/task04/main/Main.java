package by.zvv.javaonline.part04.aggregation.task04.main;

import by.zvv.javaonline.part04.aggregation.task04.entity.Account;
import by.zvv.javaonline.part04.aggregation.task04.entity.Accounts;
import by.zvv.javaonline.part04.aggregation.task04.entity.Client;
import by.zvv.javaonline.part04.aggregation.task04.enums.Bank;
import by.zvv.javaonline.part04.aggregation.task04.logic.AccountLogic;
import by.zvv.javaonline.part04.aggregation.task04.logic.BankAccountsLogic;
import by.zvv.javaonline.part04.aggregation.task04.logic.ClientLogic;
import by.zvv.javaonline.part04.aggregation.task04.view.AccountView;
import by.zvv.javaonline.part04.aggregation.task04.view.BankAccountsView;

/* Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета. 
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. 
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class Main {

	public static void main(String[] args) {
		BankAccountsLogic bal = new BankAccountsLogic();
		BankAccountsView bav = new BankAccountsView();
		ClientLogic cl = new ClientLogic();
		AccountLogic al = new AccountLogic();
		AccountView av = new AccountView();
		Accounts accounts = new Accounts();
		int totalNumberOfClients = 5;
		int totalNumberOfAccounts = 15;

		// Генерируем клиентов и счета с автоматической перекрестной привязкой
		accounts = bal.init(accounts, totalNumberOfClients, totalNumberOfAccounts);

		Client test = new Client("Тестов", "Тест", "Тестович"); // Создаем нового клиента test
		test.setAddress("any address");

		// Создаем два новых счета для клиента test
		Account a1 = new Account(Bank.BELVeb, 11000000000L, false, test, 10000);
		Account a2 = new Account(Bank.AgroPromBank, 12000000000L, true, test, 10000);

		test.addAccount(a1); // Добавляем счет в список счетов клиента test
		test.addAccount(a2); // Добавляем счет в список счетов клиента test

		// Добавляем счета в общий список счетов
		accounts.addAccountToList(a1);
		accounts.addAccountToList(a2);

		System.out.println("Поиск и вывод на экран, счет:" + a1.getAccountNumber());
		av.print(al.findAccount(bal.getAllAccounts(accounts), a1.getAccountNumber()));

		al.topUpAccount(a1, 225); // Пополнение счета a1
		al.topUpAccount(a2, 225); // Пополнение счета a2
		System.out.println();

		System.out.println("Вывод счетов отсортированных по номеру счета");
		bav.printAllAccounts(bal.sortAccountByNumber(accounts));
		System.out.println();

		System.out
				.println("Балланс отрицательных счетов: " + bal.getSumOfAccountList(bal.getNegativeAccounts(accounts)));
		System.out
				.println("Балланс положительных счетов: " + bal.getSumOfAccountList(bal.getPositiveAccounts(accounts)));
		System.out.println("Балланс всех счетов: " + bal.getSumOfAllAccounts(accounts));
		System.out.println();

		System.out.println("Балланс всех счетов по клиентам");
		bav.printSumsAccountsAllClient(cl.sortClientsByFullName(bal.getAllClients(accounts)));
		System.out.println();

		System.out.println("Заблокированные счета");
		bav.printAllAccounts(al.sortAccountsByNumber(bal.getAllNotActiveAccount(accounts)));
		System.out.println();

		System.out.println("Счета сгруппированные по банку и отсортированные по номерам счетов");
		bav.printAllAccounts(bal.sortAccountByNumberWithinBank(accounts));

	}

}
