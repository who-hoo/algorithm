package boj.level2;

import java.util.Scanner;

public class BOJ2798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드의 개수
        int m = sc.nextInt(); // 최대한 가깝게 만들 수
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }
        sc.close();

        int temp;
        int sum = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    temp = cards[i] + cards[j] + cards[k];
                    if (temp <= m && temp > sum) {
                        sum = temp;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
