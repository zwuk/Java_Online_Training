package by.zvv.javaonline.part04.aggregation.task04.bean;

import by.zvv.javaonline.part04.aggregation.task04.enums.Bank;

public class Account {
	private Bank bank;
	private Client client;
	private long accountNumber;
	private boolean active;
	private double amount;

	public Account(Client client) {
		this.client = client;
	}

	public Account(Client client, Bank bank, long accountNumber, boolean active) {
		this.client = client;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.active = active;
	}

	public Account(Client client, Bank bank, long accountNumber, boolean active, double amount) {
		this.client = client;
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.active = active;
		this.amount = amount;
	}

	public Bank getBank() {
		return bank;
	}

	public Client getClient() {
		return client;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public boolean isActive() {
		return active;
	}

	public double getAmount() {
		return amount;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + (active ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
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
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (active != other.active)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (bank != other.bank)
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [bank=" + bank + ", client=" + client + ", accountNumber=" + accountNumber
				+ ", active=" + active + ", amount=" + amount + "]";
	}

}
