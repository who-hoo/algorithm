package boj.level1;

import java.util.Scanner;

public class BOJ1330 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        String result = a > b ? ">" : (a < b ? "<" : "==");
        System.out.println(result);
    }
}
