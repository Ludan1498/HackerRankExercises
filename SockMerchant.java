package testing;

import java.util.ArrayList;
import java.util.HashMap;

public class SockMerchant {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		System.out.println(sockMerchant(9, arr));
	}

	static int sockMerchant(int n, int[] ar) {
		if (n < 2) {
			return 0;
		}
		if (ar == null ) {
			throw new IllegalArgumentException("Null Arguments");
		}
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(ar[i])) {
				hm.put(ar[i], hm.get(ar[i]) + 1);
			} else {
				hm.put(ar[i], 1);
			}
		}
		ArrayList<Integer> keyset = new ArrayList<Integer>();
		for (int i : hm.keySet()) {
			keyset.add(i);
		}
		keyset.forEach(System.out::println);
		int temp = 0;
		int counter = 0;
		for (int i : keyset) {
			while (hm.get(i) > 1) {
				counter++;
				temp = hm.get(i);
				System.out.println("pair found: " + i + "With frequency : " + hm.get(i));
				hm.put(i, temp - 2);
				System.out.println("after count: " + i + "With frequency : " + hm.get(i) + " Count is : " + counter);

			}
			if (hm.get(i) < 2) {
				System.out.println("Delteing " + hm.get(i) + "   " + i);
				hm.remove(i);

			}

		}
		return counter;

	}

}
