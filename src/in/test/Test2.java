package in.test;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, -1 };
        int target = -6;  // fixed typo from 'targate' to 'target'
        boolean result = hasPairWithSum(arr, target);  // better method name

        System.out.println(result);
    }

    public static boolean hasPairWithSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {  // avoid using the same element twice
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
