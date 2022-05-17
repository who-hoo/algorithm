package boj.level2;

/*
    문제    : BOJ 큐
    유형    : 자료 구조, 큐
	난이도   : Easy (Silver4)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/10845
    날짜    : 22.05.11(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ10845 {

    static class Queue {

        LinkedList<Integer> list = new LinkedList<>();

        void push(int x) {
            list.addLast(x);
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
            return (list.isEmpty()) ? 1 : 0;
        }

        int front() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.getFirst();
        }

        int back() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.getLast();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        StringBuilder answer = new StringBuilder();
        while (N-- > 0) {
            String command = br.readLine();
            if (command.contains("push")) {
                int i = Integer.parseInt(command.split(" ")[1]);
                queue.push(i);
            } else if (command.equals("pop")) {
                answer.append(queue.pop()).append("\n");
            } else if (command.equals("size")) {
                answer.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                answer.append(queue.empty()).append("\n");
            } else if (command.equals("front")) {
                answer.append(queue.front()).append("\n");
            } else {
                answer.append(queue.back()).append("\n");
            }
        }
        br.close();
        System.out.print(answer);
    }
}
