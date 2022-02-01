package study.shortestpath.floydwarshall;

import java.util.Arrays;
import java.util.Scanner;

/* sample input
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
*/

public class FloydWarshall {

    public final static Scanner sc = new Scanner(System.in);
    public final static int INF = (int) 1e9;

    public static int n, m;
    public static int[][] graph;

    public static void floyd() {
        for (int node = 1; node <= n; node++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    graph[from][to] =
                        Math.min(graph[from][to], graph[from][node] + graph[node][to]);
                }
            }
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt(); // 노드의 개수
        m = sc.nextInt(); // 간선의 개수

        graph = new int[n + 1][n + 1];

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int[] from : graph) {
            Arrays.fill(from, INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int from = 1; from < n + 1; from++) {
            for (int to = 1; to < n + 1; to++) {
                if (from == to) {
                    graph[from][to] = 0;
                }
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[from][to] = cost;
        }

        floyd();

        for (int from = 1; from < n + 1; from++) {
            for (int to = 1; to < n + 1; to++) {
                System.out.print(graph[from][to] == INF ? "INFINITY " : graph[from][to] + " ");
            }
            System.out.println();
        }
    }
}
