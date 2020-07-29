package by.zvv.javaonline.part04.aggregation.task05.main;

import by.zvv.javaonline.part04.aggregation.task05.entity.Request;
import by.zvv.javaonline.part04.aggregation.task05.entity.VoucherList;
import by.zvv.javaonline.part04.aggregation.task05.enums.Food;
import by.zvv.javaonline.part04.aggregation.task05.enums.Transport;
import by.zvv.javaonline.part04.aggregation.task05.enums.Type;
import by.zvv.javaonline.part04.aggregation.task05.logic.VouchersLogic;

/* Туристические путевки. 
 * Сформировать набор предложений клиенту по выбору туристической путевки различного типа 
 * (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. 
 * Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class Main {

	public static void main(String[] args) {
		VouchersLogic vl = new VouchersLogic();
		VoucherList vouchers = new VoucherList();
		int numberOfVouchers = 3000;

		vl.initVoucherList(vouchers, numberOfVouchers);

		Request request = new Request(Transport.Самолет, Food.Все_включено, 15);

		vl.sortByPlaceAndPrice(vl.getVouchersByRequest(vouchers, request))
				.print("Список путевок по запросу:" + request.print() + " с сортировкой по месту назначения и цене");

		System.out.println();

		request.setType(Type.Экскурсии);
		vl.sortByPrice(vl.getVouchersByRequest(vouchers, request))
				.print("Список путевок по запросу:" + request.print() + " с сортировкой по цене");

		System.out.println();

		Request request1 = new Request();
		request1.setPlace("Франция");
		request1.setTrans(Transport.Поезд);
		request1.setType(Type.Шопинг);

		vl.getVouchersByRequest(vouchers, request1).print("Список путевок по запросу:" + request1.print());

	}

}
