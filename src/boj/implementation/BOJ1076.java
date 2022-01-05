package boj.implementation;

import java.util.List;
import java.util.Scanner;

public class BOJ1076 {

    public static List<String> colors = List.of(
        "black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = colors.indexOf(sc.nextLine());
        int b = colors.indexOf(sc.nextLine());
        long v = (int) Math.pow(10, colors.indexOf(sc.nextLine()));
        long result = (10 * a + b) * v;
        System.out.println(result);
        sc.close();
    }
}
