package by.zvv.javaonline.part04.simpleclass.task07;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("##.##");
		Point a = new Point(-8, 2);
		Point b = new Point(7, 4.5);
		Point c = new Point(-1, -5);

		Triangle t = new Triangle(a, b, c);

		System.out.println("Площадь " + t + " = " + df.format(t.getArea()));
		System.out.println("Периметр " + t + " = " + df.format(t.getPerimeter()));
		System.out.println("Точка пересечения медиан " + t + " " + t.getMedianIntersectionPoint());
		
		Triangle t1 = new Triangle(new Point(0, 0), new Point(2, 3), new Point(2, 3));
		System.out.println("Площадь " + t1 + " = " + df.format(t1.getArea()));
		System.out.println("Периметр " + t1 + " = " + df.format(t1.getPerimeter()));
		System.out.println("Точка пересечения медиан " + t1 + " " + t1.getMedianIntersectionPoint());
	}

}
