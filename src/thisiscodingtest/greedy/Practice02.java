package thisiscodingtest.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Practice02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split(" ");
        int arrSize = Integer.parseInt(firstLine[0]);
        int addCnt = Integer.parseInt(firstLine[1]);
        int sameNumCnt = Integer.parseInt(firstLine[2]);

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrSize; i++) {
            arr.add(sc.nextInt());
        }
        sc.close();

        Collections.sort(arr, Comparator.reverseOrder());
        int sum = 0;
        while (addCnt > 0) {
            for (int i = 0; i < sameNumCnt; i++) {
                if (addCnt == 0) {
                    break;
                }
                sum += arr.get(0);
                addCnt--;
            }
            if (addCnt == 0) {
                break;
            }
            sum += arr.get(1);
            addCnt--;
        }

        System.out.println(sum);
    }
}
