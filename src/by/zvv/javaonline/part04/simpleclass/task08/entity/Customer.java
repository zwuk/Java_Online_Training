package by.zvv.javaonline.part04.simpleclass.task08.entity;

/* Создать класс Customer, спецификация которого приведена ниже. 
 * Определить конструкторы, set- и get- методы и метод toString(). 
 * Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами. 
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * 
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */
public class Customer implements Comparable<Customer> {
	private int id;
	private String surname;
	private String firstName;
	private String secondName;
	private String address;
	private long creditCardNumber;
	private long bankAccountNumber;
	private static int counter;

	public Customer() {
		increaseCounter();
		id = getCounter();		
	}

	public Customer(String surname, String firstName, String secondName) {
		this();
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

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public void setBankAccountNumber(long bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (bankAccountNumber ^ (bankAccountNumber >>> 32));
		result = prime * result + (int) (creditCardNumber ^ (creditCardNumber >>> 32));
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bankAccountNumber != other.bankAccountNumber)
			return false;
		if (creditCardNumber != other.creditCardNumber)
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
		return getClass().getSimpleName() + " [id=" + id + ", surname=" + surname + ", firstName=" + firstName + ", secondName=" + secondName
				+ ", address=" + address + ", creditCardNumber=" + creditCardNumber + ", bankAccountNumber="
				+ bankAccountNumber + "]";
	}

	@Override
	public int compareTo(Customer o) {
		return this.getId() - o.getId();
	}
	
	
	
	
	
}
