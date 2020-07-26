package by.zvv.javaonline.part04.simpleclass.task09.logic;

import java.util.List;

import by.zvv.javaonline.part04.simpleclass.task09.entity.Book;

public class BookLogic {

	public void initLibrary(List<Book> lib) {
		String[] str1 = { "Лев Толстой" };
		String[] str2 = { "Э. Л. Войнич" };
		String[] str3 = { "Н. Г. Чернышевский" };
		String[] str4 = { "Роберт Седжвик", "Кевин Уэйн" };
		String[] str5 = { "Герберт Шилдт" };
		String[] str6 = { "Берт Бейтс", "Кэти Сьерра" };
		String[] str7 = { "А. С. Пушкин" };
		String[] strTest =  { "Лев Толстой", "Роберт Седжвик", "Берт Бейтс", "Кэти Сьерра"};

		lib.add(new Book("Война и мир", str1, "Питер", 1984, 1896, 34, "Hard"));
		lib.add(new Book("Овод", str2, "Питер", 2000, 520, 14.28, "Hard"));
		lib.add(new Book("Что делать", str3, "Питер", 2010, 314, 18, "Hard"));
		lib.add(new Book("Алгоритмы на Java", str4, "Вильямс", 2013, 838, 55.67, "Soft"));
		lib.add(new Book("Филипок", str1, "Росмэн-Пресс", 2015, 96, 11.27, "Hard"));
		lib.add(new Book("Java для начинающих", str5, "Вильямс", 2012, 626, 50, "Soft"));
		lib.add(new Book("Изучаем Java", str6, "Эксмо", 2015, 720, 46.66, "Hard"));
		lib.add(new Book("Сказки", str7, " Росмэн-Пресс", 2012, 144, 7.43, "Soft"));
		lib.add(new Book("Анна Каренина", str1, "АСТ", 2018, 864, 11.27, "Soft"));
		lib.add(new Book("Тест", strTest, "АСТ", 2006, 1000, 100, "Soft"));
	}
	
}
