package in.ramesh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SortAmount {
	public static void main(String[] args) {
		
		List<Payments> payments = Arrays.asList(
				new Payments(new Date(2024,02,10).toString(), 3032.0),
				new Payments(new Date(2024,01,11).toString(), 31232.0),
				new Payments(new Date(2023,10,13).toString(), 30232.0),
				new Payments(new Date(2023,11,12).toString(), 232.0)
				
				);

		List<Payments> list = payments.stream().sorted(Comparator.comparing(Payments::getDueAmount)).toList();
		
		for(Payments pay: list) {
			System.out.println(pay);
		}
	}
}
