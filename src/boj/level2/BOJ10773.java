package boj.level2;

/*
	문제    : BOJ 제로
    유형    : 구현, 자료 구조, 스택
	난이도   : Easy (Silver4)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/10773
    날짜    : 22.02.20(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> money = new LinkedList<>();
        int k = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < k; i++) {
            int current = Integer.parseInt(br.readLine());
            if (current == 0) {
                result -= money.removeLast();
            } else {
                money.addLast(current);
                result += current;
            }
        }

        System.out.println(result);
        br.close();
    }
}
