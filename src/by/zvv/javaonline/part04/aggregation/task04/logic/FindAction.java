package by.zvv.javaonline.part04.aggregation.task04.logic;

import java.util.List;

import by.zvv.javaonline.part04.aggregation.task04.bean.Account;

public class FindAction {

	public Account findAccount(List<Account> accounts, long accountNumber) {
		
//		for(Account a : accounts) {
//			if(a.getAccountNumber() == accountNumber) {
//				return a;
//			}
//		}
//		return null;
		
		return accounts.stream().filter(x -> x.getAccountNumber() == accountNumber).findFirst().orElse(null);
	}
	
}
