package by.zvv.javaonline.part04.simpleclass.task03;

import java.util.Arrays;

/* Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, 
 * успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа. 
 * Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
public class Student {
	private String fio;
	private String group;
	private int[] academicPerformance = new int[5];

	public Student(String fio, String group, int[] academicPerformance) {
		this.fio = fio;
		this.group = group;
		this.academicPerformance = academicPerformance;
	}

	public boolean isExelentStudent() {
		for (int i = 0; i < academicPerformance.length; i++) {
			if (academicPerformance[i] < 9) {
				return false;
			}
		}
		return true;
	}

	public void print(Student[] st, int listIndex, int outputIndex) {
		System.out.printf("%2d %-15s%-6s%s\n", outputIndex, st[listIndex].getFio(), st[listIndex].getGroup(),
				st[listIndex].getAcademicPerformance());

	}

	public String getFio() {
		return fio;
	}

	public String getGroup() {
		return group;
	}

	public String getAcademicPerformance() {
		return Arrays.toString(academicPerformance);
	}

}
