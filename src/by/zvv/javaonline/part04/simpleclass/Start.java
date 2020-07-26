package by.zvv.javaonline.part04.simpleclass;

import by.zvv.javaonline.part04.simpleclass.class01.Test1;
import by.zvv.javaonline.part04.simpleclass.class02.Test2;

public class Start {

	public static void main(String[] args) {
		Test1 t1 = new Test1();
		Test2 t2 = new Test2(7, 8);
		t1.print();

		t1.setA(5);
		t1.setB(4);

		t1.print();
		System.out.println(t1.getMax() + " " + t1.getSum());

		System.out.println(t2.getA() + " " + t2.getB());
	}

}
