package boj.implementation;

import java.util.Scanner;

public class BOJ1009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int answer = 1;
            for (int j = 0; j < b; j++) {
                answer = a * answer % 10;
            }
            System.out.println(answer == 0 ? 10 : answer);
        }
        sc.close();
    }
}
