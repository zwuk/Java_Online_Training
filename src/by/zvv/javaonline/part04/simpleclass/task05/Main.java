package by.zvv.javaonline.part04.simpleclass.task05;

public class Main {

	public static void main(String[] args) {
		DecimalСounter dc = new DecimalСounter(32, 17, 14);
		DecimalСounter dc2 = new DecimalСounter();

		System.out.println(dc);

		for (int i = 0; i < 3; i++) {
			dc.incrementCounter();
			System.out.println("current++");
		}
		System.out.println(dc);

		System.out.println("current = 100");
		dc.setCurrent(100);
		System.out.println(dc);

		System.out.println("minimum = 100");
		dc.setMinimum(100);
		System.out.println(dc);

		System.out.println("minimum = -100");
		dc.setMinimum(-100);
		System.out.println(dc);

		System.out.println("current = 10");
		dc.setCurrent(10);
		System.out.println(dc);

		System.out.println("maximum = 100");
		dc.setMaximum(100);
		System.out.println(dc);

		System.out.println("maximum = -50");
		dc.setMaximum(-50);
		System.out.println(dc);

		dc.incrementCounter();
		System.out.println("current++");
		System.out.println(dc);

		dc.decrementCounter();
		System.out.println("current--");
		System.out.println(dc);

		for (int i = 3; i > 0; i--) {
			dc.decrementCounter();
			System.out.println("current--");
		}
		System.out.println(dc);

		System.out.println();
		System.out.println("Инициализация значениями по умолчанию");
		System.out.println(dc2);

	}

}
