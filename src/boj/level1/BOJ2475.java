package boj.level1;

import java.util.*;

public class BOJ2475 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.close();

        int verifiedNumber = 0;
        for (int number : numbers) {
            verifiedNumber += (number * number);
        }
        verifiedNumber %= 10;

        System.out.println(verifiedNumber);
    }
}
