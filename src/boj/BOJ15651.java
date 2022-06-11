package boj;

/*
    문제    : BOJ N과 M (3)
    유형    :
	난이도   : Hard (Silver3)
	시간    : 1h
	uri    : https://www.acmicpc.net/problem/15651
    날짜    : 22.06.11(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ15651 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] selected;

	public static void select(int n) throws IOException {
		if (n == M + 1) {
			for (int i = 1; i <= M; i++) {
				bw.write(selected[i] + " ");
			}
			bw.write("\n");
		} else {
			for (int i = 1; i <= N; i++) {
				selected[n] = i;
				select(n + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // 자연수 범위(1~N)
		M = Integer.parseInt(input[1]); // 수열의 길이
		selected = new int[N + 1];

		select(1);

		bw.close();
		br.close();
	}
}
