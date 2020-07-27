package by.zvv.javaonline.part04.aggregation.task05.main;

import by.zvv.javaonline.part04.aggregation.task05.entity.VoucherList;
import by.zvv.javaonline.part04.aggregation.task05.logic.VoucherLogic;

public class Main {

	public static void main(String[] args) {
		VoucherLogic vl = new VoucherLogic();
		VoucherList vouchers = new VoucherList();
		
		vouchers = vl.initVoucherList(vouchers, 25);
		
		vouchers.print();
	}

}
