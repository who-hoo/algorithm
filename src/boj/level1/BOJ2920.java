package boj.level1;

import java.util.*;

public class BOJ2920 {

    public static void main(String[] args) {
        int[] input = new int[8];
        String output = "";

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < input.length - 1; i++) {
            int now = input[i];
            int next = input[i + 1];
            if (now - next == -1) {
                output = "ascending";
            } else if (now - next == 1) {
                output = "descending";
            } else {
                output = "mixed";
                break;
            }
        }

        System.out.print(output);
    }
}
