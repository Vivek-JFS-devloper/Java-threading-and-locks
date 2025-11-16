package in.ramesh;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 5, 7, 7, 1, 9, 3 };
		System.out.println(secondLargest(arr)); // 7
	}

	public static int secondLargest(int[] a) {

		int max = Integer.MAX_VALUE;
		int second = Integer.MIN_VALUE;
		
		System.out.println(1>max);

		for (int num : a) {
			if (num > max) {
				second = max;
				max = num;
			}else if(num>second && num!=max) {
				second = num;
			}
		}
		return second;
	}
}
