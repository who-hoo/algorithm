package boj.level2;

/*
    문제    : BOJ 요세푸스 문제 0
    유형    : 구현, 자료 구조, 큐
	난이도   : Easy (Silver4)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/11866
    날짜    : 22.05.14(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.offer(queue.poll());
            }
            result.add(queue.poll());
        }

        String answer = result.toString();
        answer = answer.replace("[", "<");
        answer = answer.replace("]", ">");

        System.out.println(answer);
    }
}
