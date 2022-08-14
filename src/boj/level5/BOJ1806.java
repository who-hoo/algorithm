package boj.level5;

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
		for (int startIdx = 1; startIdx <= N; startIdx++) {
			for (int endIdx = startIdx; endIdx <= N; endIdx++) {
				int sum = prefixSum[endIdx] - prefixSum[startIdx - 1];
				if (sum >= S) {
					answer = Math.min(answer, endIdx - startIdx +1);
				}
			}
		}

		System.out.println((answer == Integer.MAX_VALUE) ? 0 : answer);
	}
}
