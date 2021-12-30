package boj.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            p.add(sc.nextInt());
        }
        sc.close();

        Collections.sort(p);
        int result = 0;
        int pTime = 0;
        for (int i = 0; i < n; i++) {
            pTime += p.get(i);
            result += pTime;
        }

        System.out.println(result);
    }
}
