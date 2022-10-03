package boj.bruteforce;

/*
    문제    : BOJ 회전 초밥
    유형    : 브루트포스 알고리즘
	난이도   : Easy (Silver1)
	시간    : 30m
	uri    : https://www.acmicpc.net/problem/2531
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]); // 회전 초밥 벨트에 놓인 접시의 수
        final int d = Integer.parseInt(inputs[1]); // 초밥의 가짓수
        final int k = Integer.parseInt(inputs[2]); // 연속해서 먹는 접시의 수
        final int c = Integer.parseInt(inputs[3]); // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(in.readLine());
        }
        in.close();

        Set<Integer> sushi = new HashSet<>();
        int maxTypeCount = 0;
        for (int startIndex = 0; startIndex < belt.length; startIndex++) {
            sushi.add(c);
            for (int i = 0; i < k; i++) {
                sushi.add(belt[(startIndex + i) % N]);
            }
            maxTypeCount = Math.max(maxTypeCount, sushi.size());
            sushi.clear();
        }

        System.out.println(maxTypeCount);
    }
}
