package boj.level1;

import java.util.Scanner;

public class BOJ2577 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt() * sc.nextInt() * sc.nextInt();
        sc.close();

        int[] cnt = new int[10];
        while (result > 0) {
            cnt[result % 10]++;
            result /= 10;
        }

        for (int c : cnt) {
            System.out.println(c);
        }
    }
}
