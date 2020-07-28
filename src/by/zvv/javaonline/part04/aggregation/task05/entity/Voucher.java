package by.zvv.javaonline.part04.aggregation.task05.entity;

import by.zvv.javaonline.part04.aggregation.task05.enums.Food;
import by.zvv.javaonline.part04.aggregation.task05.enums.Transport;
import by.zvv.javaonline.part04.aggregation.task05.enums.Type;

public class Voucher {
	private String place;
	private Food food;
	private Transport trans;
	private Type type;
	private int days;
	private int price;

	public Voucher(String place, Type type) {
		this.place = place;
		this.type = type;
	}

	public Voucher(String place, Food food, Transport trans, Type type, int days, int price) {
		this.place = place;
		this.food = food;
		this.trans = trans;
		this.type = type;
		this.days = days;
		this.price = price;
	}

	public String getPlace() {
		return place;
	}

	public Food getFood() {
		return food;
	}

	public Transport getTrans() {
		return trans;
	}

	public Type getType() {
		return type;
	}

	public int getDays() {
		return days;
	}

	public int getPrice() {
		return price;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public void setTrans(Transport trans) {
		this.trans = trans;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + days;
		result = prime * result + ((food == null) ? 0 : food.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + price;
		result = prime * result + ((trans == null) ? 0 : trans.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voucher other = (Voucher) obj;
		if (days != other.days)
			return false;
		if (food != other.food)
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (price != other.price)
			return false;
		if (trans != other.trans)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [place=" + place + ", food=" + food + ", trans=" + trans + ", type="
				+ type + ", days=" + days + ", price=" + price + "]";
	}
	
	public void print() {
		System.out.printf("%-11s %-11s %-14s %-11s %-4d %4d\n", place, type, food, trans, days, price);
	}

}
