package study.shortestpath.dijkstra;

import java.util.*;

/* sample input
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
*/

public class SimpleDijkstra {

    public final static Scanner sc = new Scanner(System.in);
    public final static int INF = (int) 1e9;

    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph;
    public static boolean[] visited;
    public static int[] distance;

    public static void getAllNodeInfo() {
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(from).add(new Node(to, cost));
        }
        sc.close();
    }

    public static int getSmallestNode() {
        int min = INF;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] < min && !visited[i]) {
                min = distance[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void dijkstra(int start) {
        // 시작 노드 초기화
        distance[start] = 0;
        visited[start] = true;
        for (Node node : graph.get(start)) {
            distance[node.getIndex()] = node.getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;

            // 현재 노드와 연결된 다른 노드를 확인
            for (Node node : graph.get(now)) {
                int cost = distance[now] + node.getDistance();
                if (cost < distance[node.getIndex()]) { // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                    distance[node.getIndex()] = cost;
                }
            }
        }

    }

    public static void main(String[] args) {
        n = sc.nextInt(); // 노드의 개수
        m = sc.nextInt(); // 간선의 개수
        start = sc.nextInt(); // 시작 노드

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        getAllNodeInfo();
        dijkstra(start);

        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i] == INF ? "INFINITY" : distance[i]);
        }
    }
}
