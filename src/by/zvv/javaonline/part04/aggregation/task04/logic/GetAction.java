package by.zvv.javaonline.part04.aggregation.task04.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import by.zvv.javaonline.part04.aggregation.task04.bean.Account;
import by.zvv.javaonline.part04.aggregation.task04.bean.Accounts;
import by.zvv.javaonline.part04.aggregation.task04.bean.Client;

public class GetAction {

	public List<Client> getAllClients(Accounts accounts) {
		List<Account> list = new ArrayList<Account>(accounts.getAccounts());
		List<Client> clients = list.stream().map(s -> s.getClient()).distinct().collect(Collectors.toList());
		return clients;
	}
	
	public double getSumAccountList(List<Account> accounts) {
		return accounts.stream().mapToDouble(x -> x.getAmount()).sum();
	}
	
	public double getSumAllClientAccounts(Client client) {
//		double sum = 0;
		List<Account> list = new ArrayList<>();
		list = client.getAccountNumbers();
//		for (Account a : list) {
//			sum += a.getAmount();
//		}
//		return sum;
		return list.stream().mapToDouble(x -> x.getAmount()).sum();
	}
	
	public List<Account> getNegativeAccounts(List<Account> accounts) {
		List<Account> list = new ArrayList<Account>(accounts);		
//		List<Account> result = new ArrayList<>();
		
//		for(Account a : list) {
//			if(a.getAmount() < 0) {
//				result.add(a);
//			}
//		}
//		return result;
		
		return list.stream().filter(x -> x.getAmount() < 0).collect(Collectors.toList());
	}
	
	public List<Account> getPositiveAccounts(List<Account> accounts) {
		List<Account> list = new ArrayList<Account>(accounts);
		return list.stream().filter(x -> x.getAmount() > 0).collect(Collectors.toList());
	}
	
	public List<Account> getAllNotActiveAccount(List<Account> accounts) {
		List<Account> list = new ArrayList<Account>(accounts);		
//		List<Account> result = new ArrayList<>();
//		
//		for(Account a : list) {
//			if(a.isActive() == false) {
//				result.add(a);
//			}
//		}
//		return result;
		
		return list.stream().filter(s -> s.isActive() == false).collect(Collectors.toList());
	}
}
