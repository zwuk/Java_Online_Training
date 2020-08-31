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
		
		int numberOfRegionsInCountry = 6;
		int numberOfDistrictsInRegion = 10;
		int numberOfCitiesInDistrict = 10;
		
		Country country = cl.initCountry("MyCountry", numberOfRegionsInCountry, numberOfDistrictsInRegion, numberOfCitiesInDistrict);
		
		System.out.println("Столица " + country.getName() + ": " + country.getCapital().getName());
		numberOfRegions = country.getRegions().size();
		System.out.println("Количество областей = " + numberOfRegions);
		System.out.println("Площадь " + country.getName() + ": " + country.getArea() + " кв.км.");
		
		for(Region r : country.getRegions()) {
			list.add(r.getRegionCenter());
		}
		
		System.out.println("Областные центры: ");
		
		for(City c : list) {
			cv.print(c);
		}
		
//		list.forEach(c -> cv.print(c));
//		list.forEach(cv::print);

	}

}
