package by.zvv.javaonline.part04.aggregation.task05.view;

import java.util.List;

import by.zvv.javaonline.part04.aggregation.task05.entity.Voucher;

public class VouchersView {

	public void print(List<Voucher> vouchers) {	
		System.out.println("Направление Тип путевки Питаниие       Транспорт   Дней Цена");
		System.out.println("------------------------------------------------------------");
		for(Voucher v : vouchers) {
			v.print();
		}
	}
}
