package boj;

/*
    문제    : BOJ 후보 추천하기
    유형    : 구현, 시뮬레이션
	난이도   : SoSo (Silver2)
	시간    : 1h
	uri    : https://www.acmicpc.net/problem/1713
    날짜    : 22.06.12(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class BOJ1713 {

	static class Candidate implements Comparable<Candidate> {

		int n;
		int recommendedCount;
		int sequence;

		public Candidate(int n, int sequence) {
			this.n = n;
			this.recommendedCount = 0;
			this.sequence = sequence;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Candidate candidate = (Candidate) o;
			return n == candidate.n;
		}

		@Override
		public int hashCode() {
			return Objects.hash(n);
		}

		@Override
		public int compareTo(Candidate o) {
			return Integer.compare(this.n, o.n);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int N = Integer.parseInt(br.readLine());
		final int recommendCount = Integer.parseInt(br.readLine());
		LinkedList<Candidate> list = new LinkedList<>();
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < recommendCount; i++) {
			int cur = Integer.parseInt(inputs[i]);
			Candidate candidate = new Candidate(cur, i);
			if (list.contains(candidate)) {
				list.get(list.indexOf(candidate)).recommendedCount++;
			} else {
				if (list.size() < N) {
					list.add(candidate);
				} else {
					list.sort((o1, o2) -> {
						if (o1.recommendedCount > o2.recommendedCount) {
							return -1;
						} else if (o1.recommendedCount == o2.recommendedCount) {
							return o2.sequence - o1.sequence;
						} else {
							return 1;
						}
					});
					list.removeLast();
					list.add(candidate);
				}
			}
		}
		Collections.sort(list);
		for (Candidate candidate : list) {
			bw.write(candidate.n + " ");
		}

		bw.close();
		br.close();
	}
}
