package thisiscodingtest.greedy;

import java.util.Scanner;

public class Practice04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        int result = 0;
        while (n != 1) {
            result++;
            if (n % k == 0) {
                n = n / k;
                continue;
            }
            n--;
        }

        System.out.println(result);
    }
}
