package boj.level3;

/*
	문제    : BOJ 계단 오르기
    유형    : DP
	난이도   : Hard (Silver3)
	시간    : 2h 30m
	uri    : https://www.acmicpc.net/problem/2579
    날짜    : 22.02.15(o)
    refer  : ikjo의 힌트 - (n-3)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int stair[] = new int[301];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int[] dp = new int[301];
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for (int i = 3; i <= n; i++) {
            int before1 = dp[i - 3] + stair[i - 1] + stair[i];
            int before2 = dp[i - 2] + stair[i];
            int max = Math.max(before1, before2);
//            System.out.printf("[%d] : %d, %d ===> %d %n", i, before1, before2, max);
            dp[i] = max;
        }

        System.out.println(dp[n]);
    }
}
