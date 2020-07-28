package by.zvv.javaonline.part04.aggregation.task05.logic;

import java.util.Random;

import by.zvv.javaonline.part04.aggregation.task05.entity.Voucher;
import by.zvv.javaonline.part04.aggregation.task05.entity.VoucherList;
import by.zvv.javaonline.part04.aggregation.task05.enums.Food;
import by.zvv.javaonline.part04.aggregation.task05.enums.Transport;
import by.zvv.javaonline.part04.aggregation.task05.enums.Type;

public class VoucherLogic {

	public VoucherList initVoucherList(VoucherList vouchers, int size) {
		Random rand = new Random();
		String[] places = { "Испания", "Италия", "Финляндия", "Турция", "Германия", "Португалия", "Венеция",
				"Франция" };
		Food[] foods = Food.values();
		Transport[] trans = Transport.values();
		Type[] types = Type.values();

		for (int i = 0; i < size; i++) {
			vouchers.addVoucher(new Voucher(places[rand.nextInt(places.length)], foods[rand.nextInt(foods.length)],
					trans[rand.nextInt(trans.length)], types[rand.nextInt(types.length)], 5 + rand.nextInt(4) * 5,
					1000 + rand.nextInt(8) * 250));
		}
		return vouchers;
	}
}
