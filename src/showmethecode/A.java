package showmethecode;

// SHOW ME THE DUNGEON

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N; // 몬스터의 수
	static int K; // 시루의 초기 체력

	static int MONSTER = 0;
	static int CITIZEN = 1;
	static int[][] map;

	static boolean[] visited;
	static int accumulated = 0;

	static int count = 0;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		input();

		for (int i = 1; i <= N; i++) {
			if (K >= map[i][MONSTER]) {
				visit(i);
			}
		}

		output();
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][2];
		visited = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			map[i][MONSTER] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			map[i][CITIZEN] = Integer.parseInt(st.nextToken());
		}
	}

	private static void visit(int idx) {
		visited[idx] = true;
		accumulated += map[idx][MONSTER];
		K -= accumulated;
		count += map[idx][CITIZEN];
		answer = Math.max(answer, count);
		for (int next = 1; next <= N; next++) {
			if (!visited[next] && K >= (map[next][MONSTER] + accumulated)) {
				visit(next);
			}
		}
		count -= map[idx][CITIZEN];
		K += accumulated;
		accumulated -= map[idx][MONSTER];
		visited[idx] = false;
	}

	private static void output() throws IOException {
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}
}
