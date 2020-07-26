package by.zvv.javaonline.part04.simpleclass.task09.view;

import java.util.Arrays;
import java.util.List;

import by.zvv.javaonline.part04.simpleclass.task09.entity.Book;

public class BookView {

	public static void print(Book book) {
		System.out.println("id=" + book.getId() + " ----------------");
		System.out.println("\"" + book.getTitle() + "\", " + Arrays.toString(book.getAuthors()) + " Цена: "
				+ book.getPrice() + "р.");
		System.out.println("Издательство: " + book.getPublishingHouse());
		System.out.println("Год издания: " + book.getPublishingYear());
		System.out.println("Количество страниц: " + book.getNumberOfPages());
		System.out.println("Переплет: " + book.getBindingType());
	}

	public void printAll(List<Book> books) {
		for (Book book : books) {
			print(book);
		}
	}

	public void showBookByAuthor(List<Book> lib, String str) {
		for (Book b : lib) {
			String[] authors = b.getAuthors();
			for (String author : authors) {
				if (author.toString().trim().equals(str.trim())) {
					print(b);
				}
			}
		}
	}

	public void showBookByPublisher(List<Book> lib, String str) {
		lib.stream().filter(x -> x.getPublishingHouse().trim().toUpperCase().equals(str.trim().toUpperCase()))
				.forEach(BookView::print);
	}

	public void showBookOlderYear(List<Book> lib, int year) {
		lib.stream().filter(x -> x.getPublishingYear() > year).forEach(BookView::print);
	}
}
