package by.zvv.javaonline.part04.simpleclass.task03;

import java.util.Random;

/* Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, 
 * успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа. 
 * Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		Student[] students = new Student[10];

		// массив для генерации успеваимости студентов
		int[][] p = new int[10][5];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				p[i][j] = random.nextInt(3) + 8;
			}
		}

		students[0] = new Student("Иванов Н.И.", "ПЭ-31", p[0]);
		students[1] = new Student("Петров Г.Н.", "ПЭ-21", p[1]);
		students[2] = new Student("Грапов А.А.", "Э-41", p[2]);
		students[3] = new Student("Стасенко Н.Г.", "Э-11", p[3]);
		students[4] = new Student("Абрамов М.Л.", "ПЭ-31", p[4]);
		students[5] = new Student("Громыко А.С.", "ПЭ-33", p[5]);
		students[6] = new Student("Чиж Л.Н.", "ПЭ-32", p[6]);
		students[7] = new Student("Семенов Н.С.", "ПЭ-31", p[7]);
		students[8] = new Student("Шайнов П.И.", "ПЭ-11", p[8]);
		students[9] = new Student("Громов К.Л.", "ПЭ-31", p[9]);

		System.out.println("Список студентов:");
		for (int i = 0, j = 1; i < students.length; i++, j++) {
			students[i].print(students, i, j);
		}

		System.out.println("Список отличников");
		for (int i = 0, j = 1; i < students.length; i++) {
			if (students[i].isExelentStudent()) {
				students[i].print(students, i, j);
				j++;
			} else if (i == students.length - 1 && j == 1) {
				System.out.println(" среди студентов отличников нет...");
			}
		}
	}

}
