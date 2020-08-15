package by.zvv.javaonline.part04.aggregation.task04;

import by.zvv.javaonline.part04.aggregation.task04.bean.Account;
import by.zvv.javaonline.part04.aggregation.task04.bean.Accounts;
import by.zvv.javaonline.part04.aggregation.task04.bean.Client;
import by.zvv.javaonline.part04.aggregation.task04.enums.Bank;
import by.zvv.javaonline.part04.aggregation.task04.logic.FindAction;
import by.zvv.javaonline.part04.aggregation.task04.logic.GetAction;
import by.zvv.javaonline.part04.aggregation.task04.logic.InitAction;
import by.zvv.javaonline.part04.aggregation.task04.logic.SortAccount;
import by.zvv.javaonline.part04.aggregation.task04.logic.SortClient;
import by.zvv.javaonline.part04.aggregation.task04.logic.TransferAction;
import by.zvv.javaonline.part04.aggregation.task04.view.ReportAction;

/* Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета. 
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. 
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class Runner {

	public static void main(String[] args) {
		InitAction initAction = new InitAction();
		ReportAction reportAction = new ReportAction();
		SortAccount sortAccount = new SortAccount();
		SortClient sortClient = new SortClient();
		FindAction findAction = new FindAction();
		TransferAction action1 = new TransferAction(200);
		TransferAction action2 = new TransferAction(1000);
		GetAction getAction = new GetAction();
		Accounts accounts = new Accounts();

		boolean result;

		int totalClients = 5;
		int totalAccounts = 17;

		// Генерируем клиентов и счета с автоматической перекрестной привязкой
		accounts = initAction.init(accounts, totalClients, totalAccounts);

		Client test = new Client("Тестов", "Тест", "Тестович"); // Создаем нового клиента test
		test.setAddress("any address");

		// Создаем три новых счета для клиента test
		Account a1 = new Account(test, Bank.BANKBELVEB, 11000000000L, false, 10000);
		Account a2 = new Account(test, Bank.AGROPROMBANK, 12000000000L, true, 10000);
		Account a3 = new Account(test, Bank.PRIORBANK, 13000000000L, true, 10000);

		test.addAccount(a1); // Добавляем счет в список счетов клиента test
		test.addAccount(a2); // Добавляем счет в список счетов клиента test
		test.addAccount(a3); // Добавляем счет в список счетов клиента test

		// Добавляем счета в общий список счетов
		accounts.addAccount(a1);
		accounts.addAccount(a2);
		accounts.addAccount(a3);

		System.out.println("Поиск и вывод на экран, счет:" + a1.getAccountNumber());
		reportAction.print(findAction.findAccount(accounts.getAccounts(), a1.getAccountNumber()));

		System.out.println();

		result = action1.topUpAccount(a1); // Пополнение счета a1
		reportAction.printResultTopUp(result, a1, action1); // Вывод результата пополнения счета

		result = action1.topUpAccount(a2); // Пополнение счета a2
		reportAction.printResultTopUp(result, a2, action1); // Вывод результата пополнения счета

		System.out.println();

		result = action2.transferIntoAccount(a1, a3); // Перевод со счета а1 на счет а3
		reportAction.printResultTransfer(result, a1, a3, action2); // Вывод результата перевода

		result = action2.transferIntoAccount(a2, a3); // Перевод со счета а2 на счет а3
		reportAction.printResultTransfer(result, a2, a3, action2); // Вывод результата перевода

		System.out.println();

		reportAction.printAccounts("Вывод счетов отсортированных по номеру счета",
				sortAccount.byNumber(accounts.getAccounts()));

		System.out.println();

		reportAction.printBalance("Балланс отрицательных счетов: ",
				getAction.getSumAccountList(getAction.getNegativeAccounts(accounts.getAccounts())));
		reportAction.printBalance("Балланс положительных счетов: ",
				getAction.getSumAccountList(getAction.getPositiveAccounts(accounts.getAccounts())));
		reportAction.printBalance("Балланс всех счетов: ", getAction.getSumAccountList(accounts.getAccounts()));

		System.out.println();

		reportAction.printSumsAccountsAllClient("Балланс всех счетов по клиентам",
				sortClient.byFullName(getAction.getAllClients(accounts)));

		System.out.println();

		reportAction.printAccounts("Заблокированные счета",
				sortAccount.byNumber(getAction.getAllNotActiveAccount(accounts.getAccounts())));

		System.out.println();

		reportAction.printAccounts("Счета сгруппированные по банку и отсортированные по номерам счетов",
				sortAccount.byNumberWithinBank(accounts.getAccounts()));

	}

}
