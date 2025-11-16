package in.test;

import java.util.Arrays;

public class Test3 {
	public static void main(String[] args) {
		
		 int[][] arr = {
		            {1, 0, 1},
		            {1, 0, 0},
		            {0, 0, 1}
		        };

		        arr = Arrays.stream(arr)
		                .map(row -> Arrays.stream(row)
		                        .map(n -> n == 0 ? 2 : n)
		                        .toArray()
		                )
		                .toArray(int[][]::new);

		        // Print result
		        for (int[] row : arr) {
		            System.out.println(Arrays.toString(row));
		        }
		    }
		}
