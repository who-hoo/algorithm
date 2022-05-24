package boj.level2;

/*
    문제    : BOJ 체스판 다시 칠하기
    유형    : 브루트포스 알고리즘
	난이도   : SoSo (Silver5)
	시간    : 30m
	uri    : https://www.acmicpc.net/problem/1018
    날짜    : 22.05.19(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		char[][] board = new char[N][M];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				board[row][col] = (char) br.read();
			}
			br.read();
		}
		br.close();

		int answer = (int) 1e9;
		for (int row = 0; row <= N - 8; row++) {
			for (int col = 0; col <= M - 8; col++) {
				answer = Math.min(answer, count(board, row, col));
			}
		}

		System.out.println(answer);
	}

	public static int count(char[][] board, int row, int col) {
		int startWithB = 0;
		int startWithW = 0;
		char b = 'B';
		char w = 'W';
		for (int i = row; i < row + 8; i++) {
			for (int j = col; j < col + 8; j++) {
				if (board[i][j] != b) {
					startWithB++;
				}
				if (board[i][j] != w) {
					startWithW++;
				}
				b = (b == 'B') ? 'W' : 'B';
				w = (w == 'W') ? 'B' : 'W';
			}
			char temp = b;
			b = w;
			w = temp;
		}
		return Math.min(startWithB, startWithW);
	}
}
