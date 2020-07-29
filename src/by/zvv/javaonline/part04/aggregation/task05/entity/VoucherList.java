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
	
	public List<Voucher> getVouchers() {
		return vouchers;
	}

	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}

	public void print(String str) {	
		System.out.println(str);
		System.out.println("Направление Тип путевки Питаниие       Транспорт   Дней Цена");
		System.out.println("------------------------------------------------------------");
		for(Voucher v : vouchers) {
			v.print();
		}
	}
	
}
