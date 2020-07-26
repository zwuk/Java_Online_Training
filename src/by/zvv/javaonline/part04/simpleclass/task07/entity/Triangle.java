package by.zvv.javaonline.part04.simpleclass.task07.entity;

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

	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

	public Point getC() {
		return c;
	}

	public double getLengthAB() {
		return lengthAB;
	}

	public double getLengthBC() {
		return lengthBC;
	}

	public double getLengthAC() {
		return lengthAC;
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
