package thisiscodingtest.greedy;

import java.util.Scanner;

public class Q02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - (int) '0';
        }

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (result < 2 || arr[i] < 2) {
                result += arr[i];
            } else {
                result *= arr[i];
            }
        }

        System.out.println(result);
    }
}
