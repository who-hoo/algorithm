package boj.level2;

/*
    문제    : BOJ 소수 구하기
    유형    : 수학, 정수론, 소수 판정, 에라토스테네스의 체
	난이도   : Easy (Silver3)
	시간    : 15m
	uri    : https://www.acmicpc.net/problem/1929
    날짜    : 22.05.16(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1929 {

	static boolean isPrime(int x) {
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		final int M = Integer.parseInt(input[0]); // 이상
		final int N = Integer.parseInt(input[1]); // 이하

		for (int i = 2; i < 1_000_000; i++) {
			if (M <= i && i <= N && isPrime(i)) {
				bw.write(i + "\n");
			}
		}

		br.close();
		bw.close();
	}
}
