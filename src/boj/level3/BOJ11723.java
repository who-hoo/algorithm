package boj.level3;

/*
    문제    : BOJ 집합
    유형    : 구현, 비트마스킹
	난이도   : Easy (Silver5)
	시간    : 15m
	uri    : https://www.acmicpc.net/problem/11723
    날짜    : 22.05.23(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class BOJ11723 {

	static class MySet {

		Set<Integer> set = new HashSet<>(20);

		void add(int x) {
			set.add(x);
		}

		void remove(int x) {
			set.remove(x);
		}

		char check(int x) {
			return set.contains(x) ? '1' : '0';
		}

		void toggle(int x) {
			if (set.contains(x)) {
				remove(x);
			} else {
				add(x);
			}
		}

		void all() {
			set.addAll(Set.of(
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
			);
		}

		void empty() {
			set.clear();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		MySet set = new MySet();
		while (M-- > 0) {
			String[] input = br.readLine().split(" ");
			String command = input[0];
			int x = 0;
			if (input.length > 1) {
				x = Integer.parseInt(input[1]);
			}
			switch (command) {
				case "add":
					set.add(x);
					break;
				case "remove":
					set.remove(x);
					break;
				case "check":
					bw.write(set.check(x));
					bw.write("\n");
					break;
				case "toggle":
					set.toggle(x);
					break;
				case "all":
					set.all();
					break;
				case "empty":
					set.empty();
					break;
				default:
					break;
			}
		}
		bw.close();
		br.close();
	}
}
