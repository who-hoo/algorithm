package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
			select(startTeam, i);
		}
		out.write(String.valueOf(answer));

		out.close();
		in.close();
	}

	public static void select(boolean[] starkTeam, int n) {
		if (endCondition(starkTeam)) {
			updateAnswer(starkTeam);
		}
		starkTeam[n] = true;
		for (int i = 0; i < starkTeam.length; i++) {
			if (!starkTeam[i]) {
				select(starkTeam, i);
			}
		}
		starkTeam[n] = false;
	}

	public static boolean endCondition(boolean[] starkTeam) {
		int cnt = 0;
		for (boolean st : starkTeam) {
			if (st) {
				cnt++;
			}
		}
		return cnt == (starkTeam.length / 2);
	}

	public static void updateAnswer(boolean[] starkTeam) {
		List<Integer> starkTeamMember = new ArrayList<>(starkTeam.length / 2);
		List<Integer> linkTeamMember = new ArrayList<>(starkTeam.length / 2);
		for (int i = 0; i < starkTeam.length; i++) {
			if (starkTeam[i]) {
				starkTeamMember.add(i);
				continue;
			}
			linkTeamMember.add(i);
		}

		int starkTeamStat = 0;
		int linkTeamStat = 0;
		for (int i = 0; i < starkTeamMember.size(); i++) {
			for (int j = 0; j < starkTeamMember.size(); j++) {
				starkTeamStat += stat[starkTeamMember.get(i)][starkTeamMember.get(j)];
				linkTeamStat += stat[linkTeamMember.get(i)][linkTeamMember.get(j)];
			}
		}
		answer = Math.min(answer, Math.abs(starkTeamStat - linkTeamStat));
	}
}
