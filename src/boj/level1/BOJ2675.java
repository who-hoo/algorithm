package boj.level1;

import java.util.Scanner;

public class BOJ2675 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int r = sc.nextInt();
            String s = sc.nextLine().trim();
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            for (char c : arr) {
                for (int j = 0; j < r; j++) {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
        sc.close();
    }
}
