package boj.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ9237 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> trees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            trees.add(sc.nextInt());
        }
        sc.close();

        Collections.sort(trees, Comparator.reverseOrder());
        int today = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int days = today + trees.get(i);
            result = result < days ? days : result;
            today++;
        }

        System.out.println(result + 1);
    }
}
