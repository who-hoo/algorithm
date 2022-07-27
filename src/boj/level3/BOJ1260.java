package boj.level3;

/*
    문제    : BOJ DFS와 BFS
    유형    : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
	난이도   : SoSo (Silver2)
	시간    : 50m
	uri    : https://www.acmicpc.net/problem/1260
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());
		final int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		final int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		final int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
		final boolean[][] connected = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			connected[n1][n2] = true;
			connected[n2][n1] = true;
		}

		out.write(dfs(N, V, connected));
		out.write(bfs(N, V, connected));

		out.close();
		in.close();
	}

	private static String bfs(final int N, final int V, final boolean[][] connected) {
		boolean[] visited = new boolean[N +1];
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder answer = new StringBuilder();

		queue.offer(V);
		visited[V] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			answer.append(node).append(" ");
			for (int other = 1; other <= N; other++) {
				if (connected[node][other] && !visited[other]) {
					queue.offer(other);
					visited[other] = true;
				}
			}
		}
		answer.append(System.lineSeparator());

		return answer.toString();
	}

	private static String dfs(final int N, final int V, final boolean[][] connected) {
		boolean[] visited = new boolean[N+1];
		Deque<Integer> stack = new LinkedList<>();
		StringBuilder answer = new StringBuilder();

		stack.push(V);
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) {
				answer.append(node).append(" ");
				visited[node] = true;
			}
			for (int other = N; other >= 1; other--) {
				if (connected[node][other] && !visited[other]) {
					stack.push(other);
				}
			}
		}
		answer.append(System.lineSeparator());

		return answer.toString();
	}
}
