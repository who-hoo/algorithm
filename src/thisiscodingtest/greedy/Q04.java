package thisiscodingtest.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(coins);
        int target = 1;
        for (int i = 0; i < n; i++) {
            if (target < coins[i]) {
                break;
            }
            target += coins[i];
        }

        System.out.println(target);
    }
}
