package boj.level3;

/*
	문제    : BOJ 경로 찾기
    유형    : 그래프 이론, 그래프 탐색, 프로이드-와샬
	난이도   : Easy (Silver1)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/11403
    날짜    : 22.03.04(o)
    refer  :
*/

import java.util.Scanner;

public class BOJ11403 {

    public final static int INF = (int) 1e9;

    public static int n;
    public static int[][] graph;

    public static void floyd() {
        for (int node = 0; node < n; node++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][node] == 1 && graph[node][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int connected = sc.nextInt();
                graph[i][j] = connected == 0 ? INF : connected;
            }
        }
        sc.close();

        floyd();

        for (int[] ints : graph) {
            for (int anInt : ints) {
                System.out.print(anInt == INF ? "0 " : "1 ");
            }
            System.out.println();
        }
    }
}
