package by.zvv.javaonline.part02.multiarray;

import java.util.Random;

/* Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 * 
 */
public class Main12 {

	public static void main(String[] args) {

		int n;
		int m;
		int[][] matrix;

		Random random = new Random();
		
		n = random.nextInt(10) + 5;
		m = random.nextInt(10) + 5;
		matrix = new int[n][m];

		System.out.println("Исходная матрица " + n + "x" + m);
		initMatrix(matrix);
		print(matrix);

		System.out.println("Матрица с сортировкой строк по возрастанию");
		lineSortAscending(matrix);
		print(matrix);

		System.out.println("Матрица с сортировкой строк по убыванию");
		lineSortDescending(matrix);
		print(matrix);

	}

	public static void initMatrix(int[][] matrix) {
		Random rand = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(100);
			}
		}
	}

	public static void print(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void lineSortAscending(int[][] matrix) {
		int temp;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int k = matrix[i].length - 1; k > 0; k--) {
				for (int j = 0; j < k; j++) {
					if (matrix[i][j] > matrix[i][j + 1]) {
						temp = matrix[i][j];
						matrix[i][j] = matrix[i][j + 1];
						matrix[i][j + 1] = temp;
					}
				}
			}
		}
	}

	public static void lineSortDescending(int[][] matrix) {
		int temp;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int k = matrix[i].length - 1; k > 0; k--) {
				for (int j = 0; j < k; j++) {
					if (matrix[i][j] < matrix[i][j + 1]) {
						temp = matrix[i][j];
						matrix[i][j] = matrix[i][j + 1];
						matrix[i][j + 1] = temp;
					}
				}
			}
		}
	}

}
