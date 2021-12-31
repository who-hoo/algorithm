package boj.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ropes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ropes.add(sc.nextInt());
        }
        sc.close();

//        Collections.sort(ropes);
//        System.out.println(ropes.get(0) * n);

        Collections.sort(ropes, Collections.reverseOrder());
        int cnt = 0;
        int max = -999999999;
        for (int i = 0; i < n; i++) {
            int rope = ropes.get(i);
            cnt++;
            if (max < rope * cnt) {
                max = rope * cnt;
            }
        }

        System.out.println(max);
    }
}
