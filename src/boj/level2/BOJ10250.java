package boj.level2;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ10250 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int test = 0;
        while (test < t) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            ArrayList<String> rooms = new ArrayList<>(h * w);
            for (int i = 1; i <= w; i++) {
                for (int j = 1; j <= h; j++) {
                    rooms.add("" + j + (i < 10 ? "0" + i : i));
                }
            }
            System.out.println(rooms.get(n - 1));
        }
        sc.close();
    }
}
