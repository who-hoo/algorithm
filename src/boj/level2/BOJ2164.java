package boj.level2;

/*
    문제    : BOJ 카드2
    유형    : 자료구조, 큐
	난이도   : Easy (Silver4)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/2164
    날짜    : 22.03.24(o)
    refer  :
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            cards.offer(Integer.valueOf(i));
        }
        boolean flag = true;
        while (cards.size() > 1) {
            if (flag) {
                cards.poll();
            } else {
                cards.offer(cards.poll());
            }
            flag = !flag;
        }

        System.out.println(cards.poll());
    }
}
