package by.zvv.javaonline.part04.simpleclass.task07;

//import java.text.DecimalFormat;

/* Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления 
 * площади, периметра и точки пересечения медиан.
 */
public class Triangle {
	Point a;
	Point b;
	Point c;
	double lengthAB;
	double lengthBC;
	double lengthAC;

	public Triangle(Point a, Point b, Point c) {
		if (!checkExistence(a, b, c)) {
			System.out.println("Треугольника с вершинами " + a + ", " + b + ", " + c + " не существует");
		} else {
			this.a = a;
			this.b = b;
			this.c = c;
			lengthAB = getLength(a, b);
			lengthAC = getLength(a, c);
			lengthBC = getLength(b, c);
		}
	}

	private boolean checkExistence(Point a, Point b, Point c) {
		// проверка точек на совпадение 
		if(a.equals(b) || b.equals(c) || a.equals(c)) {
			return false;
		}
		// проверка, лежат ли точки на одной линии
		if ((c.getX() - a.getX()) * (b.getY() - a.getY()) == (c.getY() - a.getY()) * (b.getX() - a.getX())) {
			return false;
		}
		return true;
	}

	private double getLength(Point a, Point b) {
		return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
	}

	public double getArea() {
		double p = (lengthAB + lengthBC + lengthAC) / 2.0;
		return Math.sqrt(p * (p - lengthAB) * (p - lengthBC) * (p - lengthAC));

	}

	public double getPerimeter() {
		return lengthAB + lengthBC + lengthAC;
	}

	public Point getMedianIntersectionPoint() {
		double xB1, yB1; // координаты середины отрезка AC (точка B1)
		double xM, yM; // координаты точки M - точка пересечения медиан треугольника (BB1/MB1 = 2/1)

		if (a == null || b == null || c == null) {
			return null;
		} else {
			xB1 = (a.getX() + c.getX()) / 2.0;
			yB1 = (a.getY() + c.getY()) / 2.0;

			xM = (2 * xB1 + b.getX()) / 3;
			yM = (2 * yB1 + b.getY()) / 3;

			return new Point(xM, yM);
		}
	}

	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

	public Point getC() {
		return c;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

//	@Override
//	public String toString() {
//		DecimalFormat df = new DecimalFormat("##.##");
//		return "Triangle [lengthAB=" + df.format(lengthAB) + ", lengthBC=" + df.format(lengthBC) + ", lengthAC="
//				+ df.format(lengthAC) + "]";
//	}

}
