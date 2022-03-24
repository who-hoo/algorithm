package boj.level2;

/*
    문제    : BOJ 소수 찾기
    유형    : 수학, 정수론, 소수 판정, 에라토스테네스의 체
	난이도   : Easy (Silver4)
	시간    : 15m
	uri    : https://www.acmicpc.net/problem/1978
    날짜    : 22.03.24(o)
    refer  :
*/

import java.util.Scanner;

public class BOJ1978 {

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        int i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int count = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (isPrime(t)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
