package thisiscodingtest.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        sc.close();

        int result = 0;
        Collections.sort(arr, Collections.reverseOrder());
        while (true) {
            if (arr.isEmpty()) {
                break;
            }
            if (arr.get(0) <= arr.size()) {
                result++;
                arr = arr.subList(arr.get(0), arr.size());
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
