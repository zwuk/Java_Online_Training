package by.zvv.javaonline.part04.simpleclass.task08.main;

import by.zvv.javaonline.part04.simpleclass.task08.view.CustomerView;

import java.util.ArrayList;
import java.util.List;

import by.zvv.javaonline.part04.simpleclass.task08.entity.Customer;
import by.zvv.javaonline.part04.simpleclass.task08.entity.CustomerList;
import by.zvv.javaonline.part04.simpleclass.task08.logic.CustomerLogic;

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
public class Main {

	public static void main(String[] args) {
		CustomerLogic cl = new CustomerLogic();
		CustomerView cv = new CustomerView();		
		CustomerList clients = new CustomerList();
		int sizeCustomersList = 10;
		long startDiapason = 10000000000000000L;
		long endDiapason = 4999999999999999999L;
		List<Customer> list = new ArrayList<Customer>();
		
		cl.initList(clients.getCustomerList(), sizeCustomersList);
		list = cl.sortByAlphabet(clients.getCustomerList());
		System.out.println("Список покупателей в алфавитном порядке");
		cv.printAll(list);
		
		System.out.println();

		System.out.println("Список покупателей по интервалу кредитных карт: от " + startDiapason + " до " + endDiapason);
		list = cl.getCustomersByCreditCardDiapason(clients.getCustomerList(), startDiapason, endDiapason);
		cv.printAll(list);
		
	}

}
