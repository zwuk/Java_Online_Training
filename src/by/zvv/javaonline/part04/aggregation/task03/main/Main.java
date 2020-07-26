package by.zvv.javaonline.part04.aggregation.task03.main;

import java.util.ArrayList;
import java.util.List;

import by.zvv.javaonline.part04.aggregation.task03.entity.City;
import by.zvv.javaonline.part04.aggregation.task03.entity.Country;
import by.zvv.javaonline.part04.aggregation.task03.entity.District;
import by.zvv.javaonline.part04.aggregation.task03.entity.Region;
import by.zvv.javaonline.part04.aggregation.task03.logic.CountryLogic;
import by.zvv.javaonline.part04.aggregation.task03.view.CountryView;

/* Создать объект класса Государство, используя классы Область, Район, Город. 
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */
public class Main {

	public static void main(String[] args) {
		CountryLogic cl = new CountryLogic();
		CountryView cv = new CountryView();
		List<City> list = new ArrayList<City>();
		int numberOfRegions;
		
		Country country = cl.initCountry("MyCountry", 5, 8, 10);
		
		System.out.println("Столица " + country.getName() + ": " + country.getCapital().getName());
		numberOfRegions = country.getRegions().size();
		System.out.println("Количество областей = " + numberOfRegions);
		System.out.println("Площадь " + country.getName() + ": " + country.getArea() + " кв.км.");
		
		for(Region r : country.getRegions()) {
			list.add(r.getRegionCenter());
		}
		System.out.println("Областные центры: ");
//		list.forEach(s -> cv.print(s));
		list.forEach(cv::print);

	}

}
