package boj.level2;

/*
    문제    : BOJ 숫자 카드 2
    유형    : 자료 구조, 정렬, 이분 탐색
	난이도   : Easy (Silver4)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/10816
    날짜    : 22.05.05(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드의 개수
        HashMap<Integer, Integer> count = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            answer.append(count.getOrDefault(n, 0)).append(" ");
        }

        br.close();
        System.out.println(answer);
    }
}
