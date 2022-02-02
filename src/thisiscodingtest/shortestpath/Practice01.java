package thisiscodingtest.shortestpath;

import java.util.*;

/* sample input
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
*/

public class Practice01 {

    public static final int INF = (int) 1e9;
    public static int[][] graph;
    public static int n, m, x, k;

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
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 회사의 개수
        m = sc.nextInt(); // 경로의 개수

        graph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        x = sc.nextInt(); // 최종 도착 회사
        k = sc.nextInt(); // 중간 경유 회사
        sc.close();

        floyd();

        int result = graph[1][k] + graph[k][x];
        System.out.println(result >= INF ? -1 : result);
    }
}
