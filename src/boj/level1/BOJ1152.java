package boj.level1;

import java.util.Scanner;

public class BOJ1152 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        sc.close();

        if (str.equals("")) {
            System.out.println(0);
        } else {
            System.out.println(str.split(" ").length);
        }
    }
}
