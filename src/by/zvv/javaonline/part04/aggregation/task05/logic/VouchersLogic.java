package by.zvv.javaonline.part04.aggregation.task05.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import by.zvv.javaonline.part04.aggregation.task05.entity.Request;
import by.zvv.javaonline.part04.aggregation.task05.entity.Voucher;
import by.zvv.javaonline.part04.aggregation.task05.entity.VoucherList;
import by.zvv.javaonline.part04.aggregation.task05.enums.Food;
import by.zvv.javaonline.part04.aggregation.task05.enums.Transport;
import by.zvv.javaonline.part04.aggregation.task05.enums.Type;

public class VouchersLogic {

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
					1000 + rand.nextInt(12) * 150));
		}
		return vouchers;
	}

	public VoucherList sortByPlace(VoucherList vouchers){
		VoucherList sortedVouchers = new VoucherList();
		List<Voucher> list = new ArrayList<Voucher>(vouchers.getVouchers());
		
//		Comparator<Voucher> comp = (x1, x2) -> x1.getPlace().compareToIgnoreCase(x2.getPlace());
		Comparator<Voucher> comp = Comparator.comparing(Voucher::getPlace);
		
		list = list.stream().sorted(comp).collect(Collectors.toList());
		
		sortedVouchers.setVouchers(list);
		return sortedVouchers;
	}
	
	public VoucherList sortByPrice(VoucherList vouchers){
		VoucherList sortedVouchers = new VoucherList();
		List<Voucher> list = new ArrayList<Voucher>(vouchers.getVouchers());
		
		Comparator<Voucher> comp = (x1, x2) -> x2.getPrice() - x1.getPrice();
//		Comparator<Voucher> comp = Comparator.comparing(Voucher::getPrice);
		
		list = list.stream().sorted(comp).collect(Collectors.toList());
		
		sortedVouchers.setVouchers(list);
		return sortedVouchers;
	}
	
	public VoucherList sortByPlaceAndPrice(VoucherList vouchers){
		VoucherList sortedVouchers = new VoucherList();
		List<Voucher> list = new ArrayList<Voucher>(vouchers.getVouchers());
		
		Comparator<Voucher> comp = (x1, x2) -> x1.getPlace().compareToIgnoreCase(x2.getPlace());
		comp = comp.thenComparing((x1, x2) -> x2.getPrice() - x1.getPrice());
		
		list = list.stream().sorted(comp).collect(Collectors.toList());
		
		sortedVouchers.setVouchers(list);
		return sortedVouchers;
	}
	
	public VoucherList getVouchersByRequest(VoucherList vouchers, Request request){
		VoucherList listV = new VoucherList();
		List<Voucher> list = new ArrayList<Voucher>(vouchers.getVouchers());
		
		if(request.getPlace() != null) {
			list = list.stream().filter(x -> x.getPlace().equals(request.getPlace())).collect(Collectors.toList());
		}
		if(request.getFood() != null) {
			list = list.stream().filter(x -> x.getFood().equals(request.getFood())).collect(Collectors.toList());
		}
		if(request.getTrans() != null) {
			list = list.stream().filter(x -> x.getTrans().equals(request.getTrans())).collect(Collectors.toList());
		}
		if(request.getType() != null) {
			list = list.stream().filter(x -> x.getType().equals(request.getType())).collect(Collectors.toList());
		}
		if(request.getDays() != 0) {
			list = list.stream().filter(x -> x.getDays() == request.getDays()).collect(Collectors.toList());
		}
		if(request.getPrice() != 0) {
			list = list.stream().filter(x -> x.getPrice() < request.getPrice()).collect(Collectors.toList());
		}
		
		listV.setVouchers(list);
		return listV;
	}
	
}
