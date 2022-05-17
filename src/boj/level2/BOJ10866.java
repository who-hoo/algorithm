package boj.level2;

/*
    문제    : BOJ 덱
    유형    : 자료 구조, 덱
	난이도   : Easy (Silver4)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/10866
    날짜    : 22.05.14(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ10866 {

    static class Deque {

        LinkedList<Integer> list = new LinkedList<>();

        void pushFront(int x) {
            list.addFirst(x);
        }

        void pushBack(int x) {
            list.addLast(x);
        }

        int popFront() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.removeFirst();
        }

        int popBack() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.removeLast();
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
        Deque deque = new Deque();
        StringBuilder answer = new StringBuilder();
        while (N-- > 0) {
            String command = br.readLine();
            if (command.contains("push_front")) {
                int i = Integer.parseInt(command.split(" ")[1]);
                deque.pushFront(i);
            } else if (command.contains("push_back")) {
                int i = Integer.parseInt(command.split(" ")[1]);
                deque.pushBack(i);
            } else if (command.equals("pop_front")) {
                answer.append(deque.popFront()).append("\n");
            } else if (command.equals("pop_back")) {
                answer.append(deque.popBack()).append("\n");
            } else if (command.equals("size")) {
                answer.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                answer.append(deque.empty()).append("\n");
            } else if (command.equals("front")) {
                answer.append(deque.front()).append("\n");
            } else {
                answer.append(deque.back()).append("\n");
            }
        }
        br.close();
        System.out.println(answer);
    }
}
