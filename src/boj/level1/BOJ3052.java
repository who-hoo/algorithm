package boj.level1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ3052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[42];
        for (int i = 0; i < 10; i++) {
            arr[sc.nextInt() % 42]++;
        }
        sc.close();

        int result = (int) Arrays.stream(arr)
            .filter(cnt -> cnt != 0)
            .count();
        System.out.println(result);
    }
}
