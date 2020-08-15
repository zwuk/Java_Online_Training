package by.zvv.javaonline.part04.aggregation.task04.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Accounts {
	private Set<Account> accounts;
	
	public Accounts() {
		accounts = new HashSet<Account>();
	}
	
	public List<Account> getAccounts(){
		List<Account> accountList = new ArrayList<Account>(accounts);
		return accountList;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public void remoteAccount(Account account) {
		account.getClient().remoteAccount(account);
		accounts.remove(account);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [accounts=" + accounts + "]";
	}
	
	
}
