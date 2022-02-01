package study.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ImprovedDijkstra {

    public final static Scanner sc = new Scanner(System.in);
    public final static int INF = (int) 1e9;

    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph;
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

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드
            Node currentNode = pq.poll();
            int dist = currentNode.getDistance();
            int now = currentNode.getIndex();
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (distance[now] < dist) {
                continue;
            }
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (Node node : graph.get(now)) {
                int cost = distance[now] + node.getDistance();
                if (cost < distance[node.getIndex()]) { // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                    distance[node.getIndex()] = cost;
                    pq.offer(new Node(node.getIndex(), node.getDistance()));
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
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        getAllNodeInfo();
        dijkstra(start);

        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i] == INF ? "INFINITY" : distance[i]);
        }
    }
}
