package boj.level3;

/*
    문제    : BOJ 1로 만들기
    유형    : 다이나믹 프로그래밍
	난이도   : Easy (Silver3)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/1463
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			if (i % 3 == 0 && i % 2 == 0) {
				memo[i] = Math.min(Math.min(memo[i / 3], memo[i / 2]), memo[i - 1]) + 1;
			} else if (i % 3 == 0) {
				memo[i] = Math.min(memo[i / 3], memo[i - 1]) + 1;
			} else if (i % 2 == 0) {
				memo[i] = Math.min(memo[i / 2], memo[i - 1]) + 1;
			} else {
				memo[i] = memo[i - 1] + 1;
			}
		}

		bw.write(String.valueOf(memo[N]));

		bw.close();
		br.close();
	}
}
