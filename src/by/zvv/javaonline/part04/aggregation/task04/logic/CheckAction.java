package by.zvv.javaonline.part04.aggregation.task04.logic;

import by.zvv.javaonline.part04.aggregation.task04.bean.Account;

public class CheckAction {

	public boolean isAccountActive(Account account) {
		return account.isActive();
	}
	
	public boolean isWithinBank(Account account1, Account account2) {
		return account1.getBank().equals(account2.getBank());
	}
}
