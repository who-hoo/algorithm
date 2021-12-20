package boj.level1;

import java.util.Scanner;

public class BOJ10950 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] arr = new int[2][t];
        for (int i = 0; i < t; i++) {
            arr[0][i] = sc.nextInt();
            arr[1][i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < t; i++) {
            System.out.println(arr[0][i] + arr[1][i]);
        }
    }
}
