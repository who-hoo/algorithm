package boj.level2;

/*
	문제    : BOJ 단어 정렬
    유형    : 문자열, 정렬
	난이도   : Easy (Silver5)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/1181
    날짜    : 22.02.17(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        br.close();

        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });

        System.out.println(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].equals(words[i])) {
                continue;
            }
            System.out.println(words[i]);
        }
    }
}
