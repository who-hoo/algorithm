package boj.level1;

import java.util.Scanner;

public class BOJ11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String numbers = sc.nextLine();
        sc.close();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += numbers.charAt(i) - '0';
        }
        System.out.println(result);
    }
}
