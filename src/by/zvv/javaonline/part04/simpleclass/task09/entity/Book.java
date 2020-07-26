package by.zvv.javaonline.part04.simpleclass.task09.entity;

import java.util.Arrays;

/* Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString(). 
 * Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами. 
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * 
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 */
public class Book {
	private int id;
	private String title;
	private String[] authors;
	private String publishingHouse;
	private int publishingYear;
	private int numberOfPages;
	private double price;
	private String bindingType;
	private static int counter;
	
	public Book() {
		increaseCounter();
		id = getCounter();
	}

	public Book(String title, String[] authors) {
		this();
		this.title = title;
		this.authors = authors;
	}

	public Book(String title, String[] authors, String publishingHouse, int publishingYear, int numberOfPages,
			double price, String bindingType) {
		this();
		this.title = title;
		this.authors = authors;
		this.publishingHouse = publishingHouse;
		this.publishingYear = publishingYear;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.bindingType = bindingType;
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

	public String getTitle() {
		return title;
	}

	public String[] getAuthors() {
		return authors;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public double getPrice() {
		return price;
	}

	public String getBindingType() {
		return bindingType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setBindingType(String bindingType) {
		this.bindingType = bindingType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + ((bindingType == null) ? 0 : bindingType.hashCode());
		result = prime * result + id;
		result = prime * result + numberOfPages;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publishingHouse == null) ? 0 : publishingHouse.hashCode());
		result = prime * result + publishingYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (!Arrays.equals(authors, other.authors))
			return false;
		if (bindingType == null) {
			if (other.bindingType != null)
				return false;
		} else if (!bindingType.equals(other.bindingType))
			return false;
		if (id != other.id)
			return false;
		if (numberOfPages != other.numberOfPages)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publishingHouse == null) {
			if (other.publishingHouse != null)
				return false;
		} else if (!publishingHouse.equals(other.publishingHouse))
			return false;
		if (publishingYear != other.publishingYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + Arrays.toString(authors) + ", publishingHouse="
				+ publishingHouse + ", publishingYear=" + publishingYear + ", numberOfPages=" + numberOfPages
				+ ", price=" + price + ", bindingType=" + bindingType + "]";
	}
	
	
}
