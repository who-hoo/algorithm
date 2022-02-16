package boj.level2;

/*
	문제    : BOJ 이항 계수 1
    유형    : 수학, 구현, 조합론
	난이도   : Easy (Bronze1)
	시간    : 30m
	uri    : https://www.acmicpc.net/problem/11050
    날짜    : 22.02.16(o)
    refer  : https://ko.wikipedia.org/wiki/%EC%9D%B4%ED%95%AD_%EA%B3%84%EC%88%98, 수학자 제리
*/

import java.util.Scanner;

public class BOJ11050 {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int result = n;
        while (n > 1) {
            n--;
            result *= n;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        int result;
        if (k == 0) {
            result = 1;
        } else {
            result = factorial(n) / (factorial(k) * factorial(n - k));
        }

        System.out.println(result);
    }
}
