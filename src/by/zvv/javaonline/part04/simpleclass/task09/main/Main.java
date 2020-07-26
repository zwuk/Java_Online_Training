package by.zvv.javaonline.part04.simpleclass.task09.main;

import java.util.Random;

import by.zvv.javaonline.part04.simpleclass.task09.entity.Library;
import by.zvv.javaonline.part04.simpleclass.task09.logic.BookLogic;
import by.zvv.javaonline.part04.simpleclass.task09.view.BookView;

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
public class Main {

	public static void main(String[] args) {
		BookLogic bl = new BookLogic();
		BookView bv = new BookView();
		Library library = new Library();
		int year;
		Random rand = new Random();
		
		String[] publisher = { "Питер", "Вильямс", "Росмэн-Пресс", "Эксмо", "АСТ" };
		String[] authors = { "Лев Толстой", "Э. Л. Войнич", "Н. Г. Чернышевский", "Роберт Седжвик", "Кевин Уэйн",
				"Герберт Шилдт", "Берт Бейтс", "Кэти Сьерра", "А. С. Пушкин" };

		bl.initLibrary(library.getLibrary());
		bv.printAll(library.getLibrary());
		System.out.println();

		int a = rand.nextInt(authors.length);
		System.out.println("Книги автора: " + authors[a]);
		bv.showBookByAuthor(library.getLibrary(), authors[a]);
		System.out.println();

		int p = rand.nextInt(publisher.length);
		System.out.println("Книги выпущенные издательством " + publisher[p]);
		bv.showBookByPublisher(library.getLibrary(), publisher[p]);
		System.out.println();

		year = 2012;
		System.out.println("Книги выпущенные после " + year + " года");
		bv.showBookOlderYear(library.getLibrary(), year);

	}

}
