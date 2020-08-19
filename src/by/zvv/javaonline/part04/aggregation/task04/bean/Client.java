package by.zvv.javaonline.part04.aggregation.task04.bean;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private int id;
	private String surname;
	private String firstName;
	private String secondName;
	private String address;
	private List<Account> accountNumbers;
	private static int counter;

	{
		accountNumbers = new ArrayList<Account>();
		increaseCounter();
		id = getCounter();
	}

	public Client(String surname, String firstName, String secondName) {
		this.surname = surname;
		this.firstName = firstName;
		this.secondName = secondName;
	}

	private void increaseCounter() {
		counter++;
	}

	private int getCounter() {
		return counter;
	}

	public int getId() {
		return id;
	}

	public String getSurname() {
		return surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getAddress() {
		return address;
	}

	public List<Account> getAccountNumbers() {
		return accountNumbers;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void addAccount(Account account) {
		this.accountNumbers.add(account);
	}

	public boolean remoteAccount(Account account) {
		return this.accountNumbers.remove(account);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((accountNumbers == null) ? 0 : accountNumbers.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Client other = (Client) obj;
		if (accountNumbers == null) {
			if (other.accountNumbers != null)
				return false;
		} else if (!accountNumbers.equals(other.accountNumbers))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + ", surname=" + surname + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", address=" + address + "]"; // + ", accountNumbers=" + accountNumbers + "]";
	}

}
