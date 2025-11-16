package in.ramesh;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test12 {
	public static void main(String[] args) {
		List<Integer> lists = Arrays.asList(5,13,10,1,203);
		
		List<Integer> collect = lists.stream().filter(num->num%2==0).collect(Collectors.toList());
		
		System.out.println(collect);
		
	}
}
