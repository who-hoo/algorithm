package boj.greedy;

import java.util.Scanner;

public class BOJ2864 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");
        sc.close();

        int min = 0;
        int max = 0;
        for (String number: numbers) {
            min += Integer.parseInt(number.replaceAll("6", "5"));
            max += Integer.parseInt(number.replaceAll("5", "6"));
        }

        System.out.printf("%d %d", min, max);
    }
}
