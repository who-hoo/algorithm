package boj.level2;

/*
	문제    : BOJ 영화감독 숌
    유형    : 브루트포스
	난이도   : Easy (Silver5)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/1436
    날짜    : 22.02.27(o)
    refer  : 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int cnt = 1;
        int number = 666;
        while (cnt < n) {
            number++;
            cnt = String.valueOf(number).contains("666") ? cnt + 1 : cnt;
        }

        System.out.println(number);
    }
}
