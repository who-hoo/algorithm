package boj.level2;

import java.util.Scanner;

public class BOJ2231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int answer = 0;
        int number = 1;
        while (number <= n) {
            String num = String.valueOf(number);
            int sum = number;
            for (int i = 0; i < num.length(); i++) {
                sum += num.charAt(i) - '0';
            }
            if (n == sum) {
                answer = number;
                break;
            }
            number++;
        }

        System.out.println(answer);
    }
}
