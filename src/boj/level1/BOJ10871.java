package boj.level1;

import java.util.Scanner;

public class BOJ10871 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.close();

        for (int number : numbers) {
            if (number < x) {
                System.out.printf("%d ", number);
            }
        }
    }
}
