package boj.level3;

/*
    문제    : BOJ 팩토리얼 0의 개수
    유형    : 수학, 임의 정밀도 / 큰 수 연산
	난이도   : SoSo (Silver5)
	시간    : 2h
	uri    : https://www.acmicpc.net/problem/1676
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BOJ1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		BigInteger n = BigInteger.valueOf(1);
		for (int i = 1; i <= N; i++) {
			n = n.multiply(BigInteger.valueOf(i));
		}

		int count = 0;
		char[] result = n.toString().toCharArray();
		for (int i = result.length - 1; i >= 0; i--) {
			if (result[i] == '0') {
				count++;
			} else {
				break;
			}
		}
		bw.write(String.valueOf(count));

		bw.close();
		br.close();
	}
}
