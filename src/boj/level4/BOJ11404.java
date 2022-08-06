package boj.level4;

/*
    문제    : BOJ 플로이드
    유형    : 그래프 이론, 플로이드-워셜
	난이도   : Easy (Gold4)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/11404
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		final int N = Integer.parseInt(in.readLine()); // 도시의 개수
		final int M = Integer.parseInt(in.readLine()); // 버스의 개수
		int[][] costs = new int[N][N];
		for (int[] cost : costs) {
			Arrays.fill(cost, 987654321);
		}
		for (int from = 0; from < N; from++) {
			for (int to = 0; to < N; to++) {
				if (from == to) {
					costs[from][to] = 0;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(tokenizer.nextToken()) - 1;
			int to = Integer.parseInt(tokenizer.nextToken()) - 1;
			int cost = Integer.parseInt(tokenizer.nextToken());
			costs[from][to] = Math.min(costs[from][to], cost);
		}

		for (int city = 0; city < N; city++) {
			for (int from = 0; from < N; from++) {
				for (int to = 0; to < N; to++) {
					costs[from][to] =
						Math.min(costs[from][to], costs[from][city] + costs[city][to]);
				}
			}
		}

		for (int from = 0; from < N; from++) {
			for (int to = 0; to < N; to++) {
				String cost = String.valueOf(costs[from][to] == 987654321 ? 0 : costs[from][to]);
				out.write(cost + " ");
			}
			out.write(System.lineSeparator());
		}

		out.close();
		in.close();
	}
}
