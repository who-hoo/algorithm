package boj.level2;

/*
    문제    : BOJ 스택
    유형    : 자료 구조, 스택
	난이도   : Easy (Silver4)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/10828
    날짜    : 22.05.05(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ10828 {

    static class Stack {

        LinkedList<Integer> list = new LinkedList<>();

        void push(int x) {
            list.addFirst(x);
        }

        int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.removeFirst();
        }

        int size() {
            return list.size();
        }

        int empty() {
            return list.isEmpty() ? 1 : 0;
        }

        int top() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.getFirst();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        StringBuilder answer = new StringBuilder();
        while (N-- > 0) {
            String command = br.readLine();
            if (command.contains("push")) {
                int i = Integer.parseInt(command.split(" ")[1]);
                stack.push(i);
            } else if (command.equals("pop")) {
                answer.append(stack.pop()).append("\n");
            } else if (command.equals("size")) {
                answer.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                answer.append(stack.empty()).append("\n");
            } else {
                answer.append(stack.top()).append("\n");
            }
        }
        br.close();
        System.out.print(answer);
    }
}
