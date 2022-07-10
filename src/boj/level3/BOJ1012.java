package boj.level3;

/*
    문제    : BOJ 유기농 배추
    유형    : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
	난이도   : Easy (Silver2)
	시간    : 40m
	uri    : https://www.acmicpc.net/problem/1012
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {

	static int[] dRow = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dCol = {0, 0, -1, 1}; // 상, 하, 좌, 우

	static class Pos {

		int row;
		int col;

		Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		final int T = Integer.parseInt(in.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			out.write(calc(in));
			out.write(System.lineSeparator());
		}

		out.close();
		in.close();
	}

	private static String calc(BufferedReader in) throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		final int M = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
		final int N = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
		final int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

		int[][] field = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		initField(in, K, field);

		int count = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (field[row][col] == 1 && !visited[row][col]) {
					Queue<Pos> queue = new LinkedList<>();
					visited[row][col] = true;
					queue.add(new Pos(row, col));
					bfs(M, N, field, visited, queue);
					count++;
				}
			}
		}

		return String.valueOf(count);
	}

	private static void bfs(int M, int N, int[][] field, boolean[][] visited, Queue<Pos> queue) {
		while (!queue.isEmpty()) {
			Pos current = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextRow = current.row + dRow[d];
				int nextCol = current.col + dCol[d];
				if (0 <= nextRow && nextRow < N
					&& 0 <= nextCol && nextCol < M
					&& field[nextRow][nextCol] == 1
					&& !visited[nextRow][nextCol]) {
					visited[nextRow][nextCol] = true;
					queue.add(new Pos(nextRow, nextCol));
				}
			}
		}
	}

	private static void initField(BufferedReader in, int K, int[][] field) throws IOException {
		for (int cabbage = 0; cabbage < K; cabbage++) {
			String[] position = in.readLine().split(" ");
			field[Integer.parseInt(position[1])][Integer.parseInt(position[0])] = 1;
		}
	}
}
