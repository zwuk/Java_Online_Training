package by.zvv.javaonline.part04.aggregation.task03.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import by.zvv.javaonline.part04.aggregation.task03.entity.City;
import by.zvv.javaonline.part04.aggregation.task03.entity.Country;
import by.zvv.javaonline.part04.aggregation.task03.entity.District;
import by.zvv.javaonline.part04.aggregation.task03.entity.Region;

public class CountryLogic {
	Random random = new Random();

	private District initDistrict(String name, double area, int numberOfCitiesInDistrict) {
		District newDistrict = new District(name, area);
		List<City> list;
		int[] cityNumber;

		cityNumber = createArrayOfNonRepeatingNumbers(numberOfCitiesInDistrict);
		for (int i = 0; i < numberOfCitiesInDistrict; i++) {
			newDistrict.addCityToDistrict(new City("City_" + cityNumber[i], 5 + random.nextInt(100)));
		}
		// Выбираем районный центр из общего списка городов
		list = getAllCities(newDistrict);
		newDistrict.setDistrictCenter(list.get(random.nextInt(list.size())));
		return newDistrict;
	}

	private Region initRegion(String name, int numberOfDistrictsInRegion, int numberOfCitiesInDistrict) {
		Region newRegion = new Region(name);
		List<City> list = new ArrayList<>();
		int[] districtNumber;

		districtNumber = createArrayOfNonRepeatingNumbers(numberOfDistrictsInRegion);
		for (int i = 0; i < numberOfDistrictsInRegion; i++) {
			newRegion.addDistrictToRegion(
					initDistrict("Distric_" + districtNumber[i], 250 + random.nextInt(500), numberOfCitiesInDistrict));
		}
		// Выбираем областной центр из общего списка городов
		list = getAllCities(newRegion);
		newRegion.setRegionCenter(list.get(random.nextInt(list.size())));
		return newRegion;
	}

	public Country initCountry(String name, int numberOfRegionsInCountry, int numberOfDistrictsInRegion,
			int numberOfCitiesInDistrict) {
		Country newCountry = new Country(name);
		List<City> list = new ArrayList<>();
		int[] regionNumber;

		regionNumber = createArrayOfNonRepeatingNumbers(numberOfRegionsInCountry);
		for (int i = 0; i < numberOfRegionsInCountry; i++) {
			newCountry.addRegionToCountry(
					initRegion("Region_" + regionNumber[i], numberOfDistrictsInRegion, numberOfCitiesInDistrict));
		}
		// Выбираем столицу государства из общего списка городов
		list = getAllCities(newCountry); 
//		list = getAllRegionsCenter(newCountry); //- если необходимо выбрать столицу из областных центров
		newCountry.setCapital(list.get(random.nextInt(list.size())));
		return newCountry;
	}

	private List<City> getAllCities(District d) {
		List<City> list = new ArrayList<City>(d.getCities());
		return list;
	}

	private List<City> getAllCities(Region r) {
		List<City> list = new ArrayList<>();
		List<District> listD = new ArrayList<>(r.getDistriсts());
		for (District d : listD) {
			list.addAll(d.getCities());
		}
		return list;
	}

	private List<City> getAllCities(Country c) {
		List<City> list = new ArrayList<>();
		List<District> listD = new ArrayList<District>();
		List<Region> listR = new ArrayList<>(c.getRegions());
		for (Region r : listR) {
			listD.addAll(r.getDistriсts());
		}
		for (District d : listD) {
			list.addAll(d.getCities());
		}
		return list;
	}
	
	private List<City> getAllRegionsCenter(Country c) {
		List<City> list = new ArrayList<>();
		List<Region> listR = new ArrayList<>(c.getRegions());
		for (Region r : listR) {
			list.add(r.getRegionCenter());
		}
		return list;
	}

	private int[] createArrayOfNonRepeatingNumbers(int size) {
		Supplier<Integer> rand = () -> random.nextInt(100);
		return Stream.generate(rand).mapToInt(x -> x + 1).distinct().limit(size).toArray();
	}
}
