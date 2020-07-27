package by.zvv.javaonline.part04.aggregation.task05.entity;

import java.util.ArrayList;
import java.util.List;

public class VoucherList {
	private List<Voucher> vouchers;

	public VoucherList() {
		vouchers = new ArrayList<Voucher>();
	}
	
	public void addVoucher(Voucher voucher) {
		this.vouchers.add(voucher);
	}

	public void removeVoucher(Voucher voucher) {
		this.vouchers.remove(voucher);
	}
	
	public void print() {	
		System.out.println("Направление Тип путевки Питаниие       Транспорт   Дней Цена");
		System.out.println("------------------------------------------------------------");
		for(Voucher v : vouchers) {
			v.print();
		}
	}
}
