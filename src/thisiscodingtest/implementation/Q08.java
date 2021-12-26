package thisiscodingtest.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        ArrayList<Character> alpha = new ArrayList<>();
        int sum = 0;
        for (char c : s.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                alpha.add(c);
            } else {
                sum += c - '0';
            }
        }
        Collections.sort(alpha);

        alpha.forEach(System.out::print);
        System.out.println(sum);
    }
}
