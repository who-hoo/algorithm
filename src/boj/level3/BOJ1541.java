package boj.level3;

/*
    문제    : BOJ 잃어버린 괄호
    유형    : 수학, 문자열, 그리디 알고리즘, 파싱
	난이도   : SoSo (Silver2)
	시간    : 40m
	uri    : https://www.acmicpc.net/problem/1541
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] input = in.readLine().toCharArray();

		// 1. 입력값을 각 숫자, 연산자로 분리하여 List<String> expressions에 저장
		List<String> expressions = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (char c : input) {
			if ('0' <= c && c <= '9') {
				sb.append(c);
			} else {
				expressions.add(sb.toString());
				expressions.add(String.valueOf(c));
				sb = new StringBuilder();
			}
		}
		expressions.add(sb.toString());

		// 2. 뺄셈 연산자 다음에 오는 숫자를 최대한 크게 만들기 위해, 뺄셈 연산자 인덱스 추출하여 minusIdxQueue에 저장
		Queue<Integer> minusIdxQueue = new LinkedList<>();
		for (int i = 0; i < expressions.size(); i++) {
			if (expressions.get(i).equals("-")) {
				minusIdxQueue.offer(i);
			}
		}

		// 3. 뺄셈 연산자 사이에 있는 덧셈을 모두 뺄셈으로 바꾸어 연산 수행(괄호를 쳤다고 생각)
		int answer = 0;
		boolean[] visited = new boolean[expressions.size()];
		while (!minusIdxQueue.isEmpty()) {
			int minusIdx = minusIdxQueue.poll();
			int nextMinusIdx = (minusIdxQueue.isEmpty() ? expressions.size() : minusIdxQueue.peek());
			for (int i = minusIdx + 1; i < nextMinusIdx; i += 2) {
				answer -= Integer.parseInt(expressions.get(i));
				visited[i] = true;
			}
		}

		// 4. 괄호를 쳤다고 생각하고 먼저 연산하고 남은 나머지 덧셈 연산 수행
		for (int i = 0; i < expressions.size(); i+=2) {
			if (!visited[i]) {
				answer += Integer.parseInt(expressions.get(i));
			}
		}
		out.write(String.valueOf(answer));

		out.close();
		in.close();
	}
}
