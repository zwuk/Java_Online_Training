package by.zvv.javaonline.part02.decomposition;

import java.util.Scanner;
import java.util.stream.IntStream;

/* Даны натуральные числа К и N. Написать метод(методы) формирования массива А, 
 * элементами которого являются числа, сумма цифр которых равна К и которые не большее N.
 */
public class Main12 {

	public static void main(String[] args) {
		int[] a;
//		int k = 5;
//		int n = 500;
		int k = init("Введите натуральное число K: ");
		int n = init("Введите натуральное число N: ");

		a = createArray(k, n);

		System.out.println("Сумма цифр элемента массива = " + k + ", значение элемента <= " + n
				+ ", количество элементов - " + a.length);
		print(a);
		print(createArray2(k, n));
	}

	public static int init(String str) {
		int num;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print(str);
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Ошибка!!! " + str);
			}
			num = sc.nextInt();
			sc.nextLine();
		} while (num <= 0);
		return num;
	}

	/*
	 * Метод проверки соответствия заданию: сумма цифр числа равна К и которые не
	 * большее N
	 */
	public static boolean check(int num, int k, int n) {
		return (sumDigitsOfNumber(num) == k && num <= n) ? true : false;
	}

	// Метод вычисления суммы всех цифр числа
	public static int sumDigitsOfNumber(int num) {
		int sum = 0;
		while (num != 0) {
			sum = sum + num % 10;
			num /= 10;
		}
		return sum;
	}

	public static int[] createArray(int k, int n) {
		int[] arrayTemp = new int[10];
		int j = 0;
		for (int i = k; i <= n; i++) {
			if (check(i, k, n)) {
				arrayTemp[j] = i;
				if (j < arrayTemp.length - 1) {
					j++;
				} else { // При переполнении создаем новый массив и копируем в него прежний
					int[] a = new int[arrayTemp.length];
					copyArray(arrayTemp, a);
					arrayTemp = new int[a.length * 2];
					copyArray(a, arrayTemp);
					j++;
				}

			}
		}
		int[] array = new int[j];
		for (int i = 0; i < array.length; i++) {
			array[i] = arrayTemp[i];
		}
		return array;
	}
	
	// Метод создания массива при помощи стрима
	public static int[] createArray2(int k, int n) {
		return IntStream.rangeClosed(k, n).filter(x -> check(x, k, n)).toArray();
	}

	public static void copyArray(int[] sourse, int[] destination) {
		for (int i = 0; i < sourse.length; i++) {
			destination[i] = sourse[i];
		}
	}

	public static void print(int[] arr) {
		if (arr == null) {
			System.out.println("Массив отсутствует");
		} else if (arr.length == 0) {
			System.out.println("Массив пуст");
		} else {
			int last = arr.length - 1;
			System.out.print('(');
			for (int i = 0;; i++) {
				System.out.print(arr[i]);
				if (i == last) {
					System.out.println(')');
					break;
				}
				System.out.print(", ");
			}
		}
	}
}
