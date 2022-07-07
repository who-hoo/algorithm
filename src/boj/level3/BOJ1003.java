package boj.level3;

/*
    문제    : BOJ 피보나치 함수
    유형    : 다이나믹 프로그래밍
	난이도   : Easy (Silver3)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/1003
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] memo = new int[41][2];
		memo[0][0] = 1;
		memo[0][1] = 0;
		memo[1][0] = 0;
		memo[1][1] = 1;
		for (int i = 2; i <= 40; i++) {
			memo[i][0] = memo[i - 1][0] + memo[i - 2][0];
			memo[i][1] = memo[i - 1][1] + memo[i - 2][1];
		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			bw.write(memo[N][0] + " ");
			bw.write(memo[N][1] + System.lineSeparator());
		}

		bw.close();
		br.close();
	}
}
