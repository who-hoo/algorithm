package thisiscodingtest.greedy;

import java.util.Scanner;

public class Q03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        String[] arr = str.split("");
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < intArr.length - 1; i++) {
            if (intArr[i] != intArr[i + 1]) {
                if (intArr[i] == 0) {
                    cnt0++;
                }
                if (intArr[i] == 1) {
                    cnt1++;
                }
            }
        }
        if (intArr[intArr.length - 1] == 0) {
            cnt0++;
        }
        if (intArr[intArr.length - 1] == 1) {
            cnt1++;
        }

        System.out.println(Integer.min(cnt0, cnt1));
    }
}
