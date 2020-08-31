package by.zvv.javaonline.part04.aggregation.task04.logic;

import by.zvv.javaonline.part04.aggregation.task04.bean.Account;

public class TransferAction {
	private double transactionAmount;
	private double percentage; // Процент, взимаемый при переводе, если счета в разных банках

	{
		percentage = 3; 
	}

	public TransferAction(double amount) {
		if (amount > 0) {
			this.transactionAmount = amount;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public boolean topUpAccount(Account account) {
		double currentAmount = account.getAmount();
		if (account.isActive()) {
			currentAmount += transactionAmount;
			account.setAmount(currentAmount);
			return true;
		} else {
			return false;
		}
	}

	public boolean withdrawFromAccount(Account account) {
		double currentAmount = account.getAmount();
		if (account.isActive() && currentAmount > 0) {
			currentAmount -= transactionAmount;
			account.setAmount(currentAmount);
			return true;
		} else {
			return false;
		}
	}

	public boolean transferIntoAccount(Account from, Account to) {
		CheckAction check = new CheckAction();

		if (check.isAccountActive(from) && check.isAccountActive(to)) {
			// Если транзакция в пределах одного банка, комиссия не взимается
			double demand = (check.isWithinBank(from, to)) 
					? from.getAmount() - transactionAmount
					: from.getAmount() - (transactionAmount + withdrawCommission());
			if (demand >= 0) {
				from.setAmount(demand);
				topUpAccount(to);
				return true;
			}
		}
		return false;
	}

	public double withdrawCommission() {
		return transactionAmount / 100 * percentage;
	}

}
