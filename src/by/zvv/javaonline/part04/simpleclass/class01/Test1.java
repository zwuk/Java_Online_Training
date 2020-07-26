package by.zvv.javaonline.part04.simpleclass.class01;

/* Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и 
 * методы изменения этих переменных. Добавьте метод, который находит сумму значений 
 * этих переменных, и метод, который находит наибольшее значение из этих двух переменных.
 */
public class Test1 {
	private int a;
	private int b;

	public void print() {
		System.out.println("Класс Test1: a = " + a + ", b = " + b);
	}

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getSum() {
		return a + b;
	}

	public int getMax() {
		return (a > b) ? a : b;
	}
}
