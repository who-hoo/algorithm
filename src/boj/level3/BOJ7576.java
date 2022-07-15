package boj.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//public class BOJ7576 {
//
//	static int[] dRow = {-1, 1, 0, 0}; // 상 하 좌 우
//	static int[] dCol = {0, 0, -1, 1}; // 상 하 좌 우
//
//	static class Pos {
//
//		int row;
//		int col;
//
//		Pos(int row, int col) {
//			this.row = row;
//			this.col = col;
//		}
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		final int M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
//		final int N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
//
//		int[][] box = new int[N][M];
//		Queue<Pos> ripe = new LinkedList<>();
//		for (int row = 0; row < N; row++) {
//			st = new StringTokenizer(in.readLine());
//			for (int col = 0; col < M; col++) {
//				box[row][col] = Integer.parseInt(st.nextToken());
//				if (box[row][col] == 1) {
//					ripe.offer(new Pos(row, col));
//				}
//			}
//		}
//
//		int day = 0;
//		while ()
//		affected(M, N, box, ripe);
//		day++;
//	}
//
//	private static void affected(int M, int N, int[][] box, Queue<Pos> ripe) {
//		int ripeTomatoCnt = ripe.size();
//		while (ripeTomatoCnt-- > 0) {
//			Pos pos = ripe.poll();
//			for (int i = 0; i < 4; i++) {
//				int nextRow = pos.row + dRow[i];
//				int nextCol = pos.col + dCol[i];
//				if (0 <= nextRow && nextRow < N
//					&& 0 <= nextCol && nextCol < M
//					&& box[nextRow][nextCol] == 0) {
//					ripe.add(new Pos(nextRow, nextCol));
//					box[nextRow][nextCol] = 1;
//				}
//			}
//		}
//	}
//
//	private static boolean allRipe(int[][] box) {
//		for (int row = 0; row < box.length; row++) {
//			for (int col = 0; col < box[row].length; col++) {
//				if (box[row][col] == 0) {
//					return false;
//				}
//			}
//		}
//
//		for (int row = 0; row < box.length; row++) {
//			for (int col = 0; col < box[row].length; col++) {
//				if (box[row][col] == 0) {
//					return false;
//				}
//			}
//		}
//
//		return true;
//	}
//}
