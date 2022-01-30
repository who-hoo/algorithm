package thisiscodingtest.dynamicprogramming;

import java.util.Scanner;

public class Practice02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] foods = new int[n];
        for (int i = 0; i < n; i++) {
            foods[i] = sc.nextInt();
        }
        sc.close();

        int[] steal = new int[100];
        steal[0] = foods[0];
        steal[1] = Math.max(foods[0], foods[1]);
        for (int i = 2; i < n; i++) {
            steal[i] = Math.max(steal[i - 1], steal[i - 2] + foods[i]);
        }

        System.out.println(steal[n - 1]);
    }
}
