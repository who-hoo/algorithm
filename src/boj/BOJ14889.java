package boj;

/*
    문제    : BOJ 스타트와 링크
    유형    : 브루트포스 알고리즘, 백트래킹
	난이도   : Hard (Silver2)
	시간    : 3h
	uri    : https://www.acmicpc.net/problem/14889
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14889 {

	static int answer = Integer.MAX_VALUE;
	static int[][] stat;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		final int N = Integer.parseInt(in.readLine());
		stat = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			boolean[] startTeam = new boolean[N];
			select(startTeam, i, 0);
		}
		out.write(String.valueOf(answer));

		out.close();
		in.close();
	}

	public static void select(boolean[] startTeam, int n, int startTeamCount) {
		if (startTeamCount == startTeam.length / 2) {
			updateAnswer(startTeam);
			return;
		}
		startTeam[n] = true;
		for (int i = n + 1; i < startTeam.length; i++) {
			if (!startTeam[i]) {
				select(startTeam, i, startTeamCount + 1);
			}
		}
		startTeam[n] = false;
	}

	public static void updateAnswer(boolean[] startTeam) {
		int startTeamStat = 0;
		int linkTeamStat = 0;
		for (int i = 0; i < startTeam.length; i++) {
			for (int j = i; j < startTeam.length; j++) {
				if (startTeam[i] && startTeam[j]) {
					startTeamStat += (stat[i][j] + stat[j][i]);
				}
				if (!startTeam[i] && !startTeam[j]) {
					linkTeamStat += (stat[i][j] + stat[j][i]);
				}
			}
		}
		answer = Math.min(answer, Math.abs(startTeamStat - linkTeamStat));
	}
}
