package boj.level1;

import java.util.Scanner;

public class BOJ1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toUpperCase();
        sc.close();

        if (word.length() == 0) {
            System.out.println("?");
            return;
        }
        if (word.length() == 1) {
            System.out.println(word);
            return;
        }
        int[] cnt = new int['Z' - 'A' + 1];
        for (int i = 0; i < word.length(); i++) {
            cnt[word.charAt(i) - 'A']++;
        }
        int max = 0;
        int nextMax = 0;
        int maxIdx = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (max <= cnt[i]) {
                nextMax = max;
                max = cnt[i];
                maxIdx = i;
            }
        }

        System.out.println(max == nextMax ? '?' : (char) ((int) 'A' + maxIdx));
    }
}
