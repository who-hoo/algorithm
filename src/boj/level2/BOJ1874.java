package boj.level2;

/*
    문제    : BOJ 스택 수열
    유형    : 자료 구조, 스택
	난이도   : Easy (Silver3)
	시간    : 30m
	uri    : https://www.acmicpc.net/problem/1874
    날짜    : 22.05.17(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int targetIdx = 0;
        int i = 1;
        while (targetIdx < n) {
            if (i > n) {
                answer = new StringBuilder();
                answer.append("NO");
                break;
            }
            stack.push(i);
            answer.append("+\n");
            while (!stack.empty() && stack.peek() == target[targetIdx]) {
                answer.append("-\n");
                stack.pop();
                targetIdx++;
            }
            i++;
        }

        System.out.println(answer);
    }
}
