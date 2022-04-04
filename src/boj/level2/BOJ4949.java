package boj.level2;

/*
    문제    : BOJ 균형잡힌 세상
    유형    : 자료 구조, 문자열, 스택
	난이도   : Easy (Silver4)
	시간    : 15m
	uri    : https://www.acmicpc.net/problem/4949
    날짜    : 22.04.04(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {

    public static String check(String line) {
        Stack<Character> stack = new Stack();
        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
                continue;
            }
            if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty() ? "yes" : "no";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals(".")) {
            System.out.println(check(line));
        }
        br.close();
    }
}
