package by.zvv.javaonline.part04.aggregation.task05.entity;

import by.zvv.javaonline.part04.aggregation.task05.enums.Food;
import by.zvv.javaonline.part04.aggregation.task05.enums.Transport;
import by.zvv.javaonline.part04.aggregation.task05.enums.Type;

public class Request {
	private String place;
	private Food food;
	private Transport trans;
	private Type type;
	private int days;
	private int price;

	public Request() {

	}

	public Request(Transport trans, Food food, int days) {
		this.food = food;
		this.trans = trans;
		this.days = days;
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
	public String toString() {
		return "Request [place=" + place + ", food=" + food + ", trans=" + trans + ", type=" + type + ", days=" + days
				+ ", price=" + price + "]";
	}

	public String print() {
		StringBuilder sb = new StringBuilder();

		sb.append("(");

		if (place != null) {
			sb.append(place);
		}
		if (food != null) {
			if (sb.length() != 1) {
				sb.append(", ");
			}
			sb.append(food);
		}
		if (trans != null) {
			if (sb.length() != 1) {
				sb.append(", ");
			}
			sb.append(trans);
		}
		if (type != null) {
			if (sb.length() != 1) {
				sb.append(", ");
			}
			sb.append(type);
		}
		if (days != 0) {
			if (sb.length() != 1) {
				sb.append(", на ");
			}
			sb.append(days);
			sb.append(" дней");
		}
		if (price != 0) {
			if (sb.length() != 1) {
				sb.append(", не дороже ");
			}
			sb.append(price);
		}
		sb.append(")");

		return sb.toString();
	}
}
