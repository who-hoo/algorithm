package boj.level2;

/*
    문제    : BOJ 괄호
    유형    : 자료 구조, 문자열, 스택
	난이도   : Easy (Silver4)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/9012
    날짜    : 22.04.09(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {

    public static String check(String str) {
        Stack<Character> ps = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                ps.push(c);
            }
            if (c == ')') {
                if (ps.isEmpty() || ps.peek() != '(') {
                    return "NO";
                }
                ps.pop();
            }
        }
        return ps.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            answer.append(check(br.readLine()))
                .append("\n");
        }
        System.out.println(answer);
    }
}
