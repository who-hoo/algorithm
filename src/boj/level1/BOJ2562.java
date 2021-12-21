package boj.level1;

import java.util.Scanner;

public class BOJ2562 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int idx = 1;
        for (int i = idx; i < 10; i++) {
            int num = sc.nextInt();
            if (num == 99) {
                max = num;
                idx = i;
                break;
            }
            if (max < num) {
                max = num;
                idx = i;
            }
        }
        sc.close();

        System.out.println(max);
        System.out.println(idx);
    }
}
