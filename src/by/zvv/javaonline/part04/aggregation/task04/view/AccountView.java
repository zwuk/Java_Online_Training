package by.zvv.javaonline.part04.aggregation.task04.view;

import by.zvv.javaonline.part04.aggregation.task04.entity.Account;

public class AccountView {

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
}
