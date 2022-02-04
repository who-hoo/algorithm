package boj.level2;

import java.util.Scanner;

public class BOJ2775 {

    public static int[][] APT = new int[15][15];

    public static void init() {
        for (int i = 0; i < 15; i++) {
            APT[i][1] = 1;
            APT[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
            }
        }
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(APT[k][n]);
        }
        sc.close();
    }
}
