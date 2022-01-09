package boj.level2;

import java.util.Scanner;

public class BOJ2292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int add = 0;
        int room = 1;
        for (int i = 1; i < 1_000_000_000; i += add) {
            if (n <= i) {
                break;
            }
            add += 6;
            room++;
        }
        System.out.println(room);
    }
}
