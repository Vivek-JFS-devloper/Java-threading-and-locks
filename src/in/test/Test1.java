package in.test;

public class Test1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		int count = 1;
		int b = 0;
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			b++;
			if(b==count) {
				System.out.println();
				count++;
				b=0;
			}
		}
	}
}
