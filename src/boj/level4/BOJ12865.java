package boj.level4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ12865 {

	static int N;
	static int K;
	static int[] weights;
	static int[] values;
	static boolean[] visited;
	static int totalWeight;
	static int totalValue;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); // 물품의 수
		K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

		weights = new int[N];
		values = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			totalWeight = 0;
			check(i);
		}

		out.write(String.valueOf(answer));

		out.close();
		in.close();
	}

	private static void check(int n) {
		visited[n] = true;
		totalValue += values[n];
		totalWeight += weights[n];
		answer = Math.max(answer, totalValue);
		for (int next = 0; next < N; next++) {
			if (!visited[next] && totalWeight + weights[next] <= K) {
				check(next);
			}
		}
		totalWeight -= weights[n];
		totalValue -= values[n];
		visited[n] = false;
	}
}
