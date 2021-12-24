package thisiscodingtest.implementation;

import java.util.Scanner;

public class Practice02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        int cnt = 0;
        for (int h = 0; h <= n; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    String hh = h < 10 ? "0" + h : "" + h;
                    String mm = m < 10 ? "0" + m : "" + m;
                    String ss = s < 10 ? "0" + s : "" + s;
                    String time = hh + mm + ss;
                    if (time.indexOf(Integer.toString(k)) != -1) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
