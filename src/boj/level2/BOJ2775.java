package boj.level2;

import java.util.Scanner;

public class BOJ2775 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int k = sc.nextInt(); // 층
            int n = sc.nextInt(); // 호
            int[][] apt = new int[k + 1][n + 1];
            for (int j = 0; j <= n; j++) {
                apt[0][j] = j;
            }
            for (int j = 1; j <= k; j++) {
                int sum = 0;
                for (int l = 0; l <= n; l++) {
                    sum += apt[j - 1][l];
                    apt[j][l] = sum;
                }
            }
            System.out.println(apt[k][n]);
        }
        sc.close();
    }
}
