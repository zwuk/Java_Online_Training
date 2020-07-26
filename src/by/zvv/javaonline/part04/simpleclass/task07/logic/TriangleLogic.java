package by.zvv.javaonline.part04.simpleclass.task07.logic;

import by.zvv.javaonline.part04.simpleclass.task07.entity.Point;
import by.zvv.javaonline.part04.simpleclass.task07.entity.Triangle;

public class TriangleLogic {
	
	public double getArea(Triangle t) {
		double lengthAB = t.getLengthAB();
		double lengthBC = t.getLengthBC();
		double lengthAC = t.getLengthAC();
		double p = (lengthAB + lengthBC + lengthAC) / 2.0;
		return Math.sqrt(p * (p - lengthAB) * (p - lengthBC) * (p - lengthAC));
	}
	
	public double getPerimeter(Triangle t) {
		return t.getLengthAB() + t.getLengthBC() + t.getLengthAC();
	}

	public Point getMedianIntersectionPoint(Triangle t) {
		double xB1, yB1; // координаты середины отрезка AC (точка B1)
		double xM, yM; // координаты точки M - точка пересечения медиан треугольника (BB1/MB1 = 2/1)

		if (t.getA() == null || t.getB() == null || t.getC() == null) {
			return null;
		} else {
			xB1 = (t.getA().getX() + t.getC().getX()) / 2.0;
			yB1 = (t.getA().getY() + t.getC().getY()) / 2.0;

			xM = (2 * xB1 + t.getB().getX()) / 3;
			yM = (2 * yB1 + t.getB().getY()) / 3;

			return new Point(xM, yM);
		}
	}
}
