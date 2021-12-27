package boj.level1;

import java.util.Scanner;

public class BOJ10809 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        for (int i ='a'; i <= 'z'; i++) {
            System.out.printf("%d ", s.indexOf(i));
        }
    }
}
