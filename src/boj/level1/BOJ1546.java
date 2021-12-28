package boj.level1;

import java.util.Scanner;

public class BOJ1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            if (m < score[i]) {
                m = score[i];
            }
        }
        sc.close();

        double newScore = 0.0;
        for (int i = 0; i < n; i++) {
            newScore += (double) score[i] / m * 100;
        }
        System.out.println(newScore / n);
    }
}
