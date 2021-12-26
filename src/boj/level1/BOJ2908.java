package boj.level1;

import java.util.Scanner;

public class BOJ2908 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        String sangsuA = "";
        String sangsuB = "";
        for (int i = 2; i >= 0; i--) {
            sangsuA += strA.charAt(i);
            sangsuB += strB.charAt(i);
        }

        System.out.println(Math.max(Integer.parseInt(sangsuA), Integer.parseInt(sangsuB)));
    }
}
