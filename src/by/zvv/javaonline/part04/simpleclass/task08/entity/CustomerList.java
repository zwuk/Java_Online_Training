package by.zvv.javaonline.part04.simpleclass.task08.entity;

import java.util.ArrayList;
import java.util.List;

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
public class CustomerList {
	private List<Customer> customerList;
	
	public CustomerList() {
		customerList = new ArrayList<Customer>();
	}
	
	public void addCustomer(Customer c) {
		customerList.add(c);
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerList == null) ? 0 : customerList.hashCode());
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
		CustomerList other = (CustomerList) obj;
		if (customerList == null) {
			if (other.customerList != null)
				return false;
		} else if (!customerList.equals(other.customerList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [customerList=" + customerList + "]";
	}
	
	
}
