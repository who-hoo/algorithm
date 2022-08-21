package boj.level5;

/*
    문제    : BOJ 부분합
    유형    : 누적 합, 두 포인터
	난이도   : Hard (Gold4)
	시간    : 1h
	uri    : https://www.acmicpc.net/problem/1806
    refer  : https://www.youtube.com/watch?v=rI8NRQsAS_s
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		final int N = Integer.parseInt(tokenizer.nextToken()); // 수열의 길이
		final int S = Integer.parseInt(tokenizer.nextToken()); // 연속된 수들의 부분합
		int[] arr = new int[N + 1];
		int[] prefixSum = new int[N + 1];
		tokenizer = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}
		in.close();

		int answer = Integer.MAX_VALUE;
		int start = 1;
		int end = 1;
		while (end <= N) {
			if (prefixSum[end] - prefixSum[start - 1] >= S) {
				answer = Math.min(answer, end - start + 1);
				start++;
			} else {
				end++;
			}
		}
		System.out.println((answer == Integer.MAX_VALUE) ? 0 : answer);
	}
}
