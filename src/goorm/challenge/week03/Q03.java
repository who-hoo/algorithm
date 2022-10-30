package goorm.challenge.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q03 {

    private final static int INF = (int) 1e9;
    private static int N, M, K;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        input();
        floyd();
        output();
    }

    private static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tokenizer.nextToken()); // 섬의 개수
        M = Integer.parseInt(tokenizer.nextToken()); // 다리의 개수
        K = Integer.parseInt(tokenizer.nextToken()); // 건널 최대 다리의 개수

        graph = new int[N][N];
        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int[] from : graph) {
            Arrays.fill(from, INF);
        }
        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int from = 0; from < N; from++) {
            for (int to = 0; to < N; to++) {
                if (from == to) {
                    graph[from][to] = 0;
                }
            }
        }
        // 각 간선에 대한 정보를 입력 받아 초기화
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            int node1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int node2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }
        in.close();
    }

    private static void floyd() {
        for (int node = 0; node < N; node++) {
            for (int from = 0; from < N; from++) {
                for (int to = 0; to < N; to++) {
                    graph[from][to] =
                        Math.min(graph[from][to], graph[from][node] + graph[node][to]);
                }
            }
        }
    }

    private static void output() {
        String answer = (graph[0][N - 1] <= K) ? "YES" : "NO";
        System.out.println(answer);
    }
}
