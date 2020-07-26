package by.zvv.javaonline.part04.aggregation.task03.view;

import by.zvv.javaonline.part04.aggregation.task03.entity.City;
import by.zvv.javaonline.part04.aggregation.task03.entity.District;
import by.zvv.javaonline.part04.aggregation.task03.entity.Region;

public class CountryView {

	public void print(City city) {
		System.out.printf("%10s, численность населения: %3d тыс.\n", city.getName(), city.getPopulationSize());
	}

	public void print(District district) {
		System.out.printf("%10s, числ. нас.: %3d тыс., райцентр: %-8s \n", district.getName(),
				district.getPopulationSize(), district.getDistrictCenter().getName());
	}
	
	public void print(Region region) {
		System.out.printf("%10s, числ. нас.: %3d тыс., областной центр: %-8s \n", region.getName(),
				region.getPopulationSize(), region.getRegionCenter().getName());
	}
}
