package boj.level2;

/*
	문제    : BOJ 좌표 정렬하기
    유형    : 정렬
	난이도   : Easy (Silver5)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/11650
    날짜    : 22.02.24(o)
    refer  :
*/

import java.util.Arrays;
import java.util.Scanner;

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ11650 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }
        sc.close();

        Arrays.sort(points, (p1, p2) -> {
            if (p1.x != p2.x) {
                return p1.x - p2.x;
            } else {
                return p1.y - p2.y;
            }
        });

        for (Point point : points) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
