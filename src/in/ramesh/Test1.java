package in.ramesh;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		 int[] nums1 = {1,2,3,0,0,0};
	        int[] nums2 = {2,5,6};
	        merge(nums1, 3, nums2, 3);
	        System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1; // pointer for nums1
		int j = n - 1; // pointer for nums2
		int k = m + n - 1; // pointer for end of nums1

		// Merge from the back
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
			} else {
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}

		// If any elements left in nums2
		while (j >= 0) {
			nums1[k] = nums2[j];
			j--;
			k--;
		}
	}
}
