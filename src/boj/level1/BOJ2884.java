package boj.level1;

import java.time.LocalTime;
import java.util.Scanner;

public class BOJ2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        LocalTime time = LocalTime.of(h, m);
        time = time.minusMinutes(45);
        System.out.printf("%d %d", time.getHour(), time.getMinute());
    }
}
