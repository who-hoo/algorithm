package boj.level3;

/*
    문제    : BOJ 잃어버린 괄호
    유형    : 수학, 문자열, 그리디 알고리즘, 파싱
	난이도   : SoSo (Silver2)
	시간    : 40m
	uri    : https://www.acmicpc.net/problem/1541
    refer  : https://st-lab.tistory.com/148
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = Integer.MAX_VALUE;

		// 1. 뺄셈을 기준으로 1차적으로 문자열을 분리
		String[] splitByMinus = in.readLine().split("-");

		// 2. 분리된 문자열들 각각에 포함된 정수 값들을 모두 더해준 후, 각각 더해진 값들을 빼준다.
		for (String expression : splitByMinus) {
			// 2-1. 분리된 문자열들 각각에 포함된 정수 값들을 모두 더해준 후,
			int current = 0;
			StringTokenizer st = new StringTokenizer(expression, "+");
			while (st.hasMoreTokens()) {
				current += Integer.parseInt(st.nextToken());
			}
			// 2-2. 각각 더해진 값들을 빼준다.
			if (answer == Integer.MAX_VALUE) { // 첫번째 수는 양수임에 주의, sum이 초기값(MAX_VALUE)라면 빼는 것이 아니라 첫번재 토큰으로 변경
				answer = current;
			} else {
				answer -= current;
			}
		}
		out.write(String.valueOf(answer));

		out.close();
		in.close();
	}
}
