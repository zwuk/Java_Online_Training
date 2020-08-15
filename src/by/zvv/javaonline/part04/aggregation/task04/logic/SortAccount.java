package by.zvv.javaonline.part04.aggregation.task04.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import by.zvv.javaonline.part04.aggregation.task04.bean.Account;

public class SortAccount {
	
	public List<Account> byNumber(List<Account> accounts) {
		List<Account> sortedList = new ArrayList<Account>(accounts);
		Comparator<Account> comp = Comparator.comparing(o -> o.getAccountNumber());
		
		sortedList.sort(comp);
		return sortedList;
	}
	
	public List<Account> byNumberWithinBank(List<Account> accounts) {
		List<Account> sortedList = new ArrayList<Account>(accounts);
		Comparator<Account> comp = Comparator.comparing(o -> o.getBank());
		comp = comp.thenComparing(o -> o.getAccountNumber());
//		Comparator<Account> comp = (x1, x2) -> x1.getBank().compareTo(x2.getBank());
//		comp = comp.thenComparing((x1, x2) -> (int) ((x1.getAccountNumber() - x2.getAccountNumber()) / 1000));

		sortedList.sort(comp);
		return sortedList;
	}
}
