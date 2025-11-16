package in.test;

public class Test4 {
    public static void main(String[] args) {
        String str = "aabbcccabbccaabcbdddd";

        char maxChar = str.charAt(0);
        int maxCount = 1;

        char currentChar = str.charAt(0);
        int currentCount = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                currentCount++;
            } else {
                currentChar = str.charAt(i);
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxChar = currentChar;
            }
        }

        System.out.println("Max consecutive character: " + maxChar);
        System.out.println("Length: " + maxCount);
    }
}
