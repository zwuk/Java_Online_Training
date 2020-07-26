package by.zvv.javaonline.part04.simpleclass.task07.main;

import java.text.DecimalFormat;

import by.zvv.javaonline.part04.simpleclass.task07.entity.Point;
import by.zvv.javaonline.part04.simpleclass.task07.entity.Triangle;
import by.zvv.javaonline.part04.simpleclass.task07.logic.TriangleLogic;

public class Main {

	public static void main(String[] args) {
		TriangleLogic tl = new TriangleLogic();
		DecimalFormat df = new DecimalFormat("##.##");
		Point a = new Point(-8, 2);
		Point b = new Point(7, 4.5);
		Point c = new Point(-1, -5);

		Triangle t = new Triangle(a, b, c);

		System.out.println("Площадь " + t + " = " + df.format(tl.getArea(t)));
		System.out.println("Периметр " + t + " = " + df.format(tl.getPerimeter(t)));
		System.out.println("Точка пересечения медиан " + t + " " + tl.getMedianIntersectionPoint(t));
		
		Triangle t1 = new Triangle(new Point(0, 0), new Point(2, 3), new Point(2, 3));
		System.out.println("Площадь " + t1 + " = " + df.format(tl.getArea(t1)));
		System.out.println("Периметр " + t1 + " = " + df.format(tl.getPerimeter(t1)));
		System.out.println("Точка пересечения медиан " + t1 + " " + tl.getMedianIntersectionPoint(t1));
	}

}
