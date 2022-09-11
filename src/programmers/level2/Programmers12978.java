package programmers.level2;

/*
    문제    : 프로그래머스 부분합
    유형    : 다익스트라
	난이도   : SoSo (Level 2)
	시간    : 1h
	uri    : https://school.programmers.co.kr/learn/courses/30/lessons/17677?language=java
    refer  :
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers12978 {

    private static class Node implements Comparable<Node> {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }

    private static final int INF = (int) 1e9;

    private ArrayList<ArrayList<Node>> map;
    private int[] distances;

    public int solution(int N, int[][] road, int K) {
        init(N, road);
        dijkstra();
        return (int) Arrays.stream(distances)
            .filter(distance -> distance <= K)
            .count();
    }

    private void init(int N, int[][] road) {
        map = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }
        distances = new int[N];
        Arrays.fill(distances, INF);
        for (int[] r : road) {
            int from = r[0] - 1;
            int to = r[1] - 1;
            int distance = r[2];
            map.get(from).add(new Node(to, distance));
            map.get(to).add(new Node(from, distance));
        }
    }

    private void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        distances[0] = 0;
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            if (distances[currentNode.index] < currentNode.distance) {
                continue;
            }
            for (Node node : map.get(currentNode.index)) {
                if (distances[currentNode.index] + node.distance < distances[node.index]) {
                    distances[node.index] = distances[currentNode.index] + node.distance;
                    pq.offer(new Node(node.index, node.distance));
                }
            }
        }
    }

    public static void main(String[] args) {
        Programmers12978 sol = new Programmers12978();
        int[] N = {5, 6};
        int[][][] road = {
            {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}},
            {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}
        };
        int[] K = {3, 4};
        for (int i = 0; i < N.length; i++) {
            System.out.println(sol.solution(N[i], road[i], K[i]));
        }
    }
}
