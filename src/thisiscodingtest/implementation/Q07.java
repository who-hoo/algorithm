package thisiscodingtest.implementation;

import java.util.Scanner;

public class Q07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        String score = String.valueOf(n);
        String left = score.substring(0, (score.length() / 2));
        String right = score.substring(score.length() / 2);
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < score.length() / 2; i++) {
            leftSum += left.charAt(i) - '0';
            rightSum += right.charAt(i) - '0';
        }

        System.out.println(leftSum == rightSum ? "LUCKY" : "READY");
    }
}
