package thisiscodingtest.greedy;

import java.util.Scanner;

public class Practice01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000 - sc.nextInt();
        sc.close();

        int[] coins = new int[]{500, 100, 50, 10, 5, 1};
        int i = 0;
        int result = 0;
        while (n != 0) {
            result += n / coins[i];
            n %= coins[i];
            i++;
        }

        System.out.println(result);
    }
}
