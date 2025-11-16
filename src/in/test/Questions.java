package in.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Questions {
	public static void main(String[] args) {

		String s = "Hello";
		boolean palindrome = isPalindrome(s);
		System.err.println(palindrome);

		List<Employee> employee = Arrays.asList(new Employee("Arun", 10), new Employee("Bojja", 10),
				new Employee("Amit", 30), new Employee("Bojja", 40), new Employee("Arun", 50),
				new Employee("Chetan", 40), new Employee("Chetan", 30));

		Map<String, Long> collect = employee.stream().filter(em -> em.age() > 20)
				.collect(Collectors.groupingBy(Employee::name, Collectors.counting()));

		List<String> collect2 = collect.entrySet().stream().filter(name -> name.getValue() > 1).map(e -> e.getKey())
				.collect(Collectors.toList());

		System.err.println(collect2);

	}

	static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);

		return sb.reverse().toString() == s;
	}

	boolean issame(int[] freq, int[] window) {
		for (int i = 0; i < 26; i++) {
			if (freq[i] != window[i]) {
				return false;
			}

		}
		return true;
	}

	
	//pemutations
	public boolean checkInclusion(String s1, String s2) {

		int[] freq = new int[26];

		int[] window = new int[26];
		for (int i = 0; i < freq.length; i++) {
			freq[i] = 0;
			// 0000000-26
			// 1000000
			// 1100000--freq
			// window[i]=0;
		}

		for (int i = 0; i < s1.length(); i++) {
			freq[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			int windowsize = s1.length();
			int windowindex, idx;
			Arrays.fill(window, 0);

			windowindex = 0;
			idx = i;
			while (windowindex < s1.length() && idx < s2.length()) {
				window[s2.charAt(idx) - 'a']++;
				// 000010001
				windowindex++;
				idx++;
			}

			if (issame(freq, window)) {
				return true;
			}

		}

		return false;

	}

}

record Employee(String name, Integer age) {
}
