package thisiscodingtest.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 5 3 1 2 5 4 3 5 5 6 6 5
 */
public class Practice03 {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        sc.close();

        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            int bElement = b.get(i);
            if (a.get(i) < b.get(i)) { // 1 2 3 4 5
                a.set(i, bElement);    // 5 5 2 1 1
            } else {
                break;
            }
        }
        int total = 0;
        for (int i = 0; i < a.size(); i++) {
            total += a.get(i);
        }
        System.out.println(total);
    }
}
