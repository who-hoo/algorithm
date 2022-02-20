package boj.level2;

/*
	문제    : BOJ 좌표 정렬하기 2
    유형    : 정렬
	난이도   : Easy (Silver5)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/11651
    날짜    : 22.02.19(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ11651 {

    static class Point implements Comparable<Point> {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.y != o.y) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }
        sc.close();

        Collections.sort(points);

        for (Point point : points) {
            System.out.println(point);
        }
    }
}
