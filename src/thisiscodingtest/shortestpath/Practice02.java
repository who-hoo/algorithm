package thisiscodingtest.shortestpath;

import java.util.*;

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

/* sample input
3 2 1
1 2 4
1 3 2
*/

public class Practice02 {

    static final Scanner sc = new Scanner(System.in);
    static final int INF = (int) 1e9;

    static int n, m, c;
    static ArrayList<ArrayList<Node>> graph;
    static int[] distance;

    static void init() {
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new Node(y, z));
        }

        sc.close();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));
        distance[c] = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int d = n.getDistance();
            int now = n.getIndex();
            if (distance[now] < d) {
                continue;
            }
            for (Node node : graph.get(now)) {
                int cost = distance[now] + node.getDistance();
                if (cost < distance[node.getIndex()]) {
                    distance[node.getIndex()] = cost;
                    pq.offer(new Node(node.getIndex(), node.getDistance()));
                }
            }
        }
    }

    static String calcSendMessageTime() {
        int cityCnt = 0;
        int sendingTime = 0;
        for (int d : distance) {
            if (d >= INF) {
                continue;
            }
            cityCnt++;
            if (d > sendingTime) {
                sendingTime = d;
            }
        }
        cityCnt--;
        return "" + cityCnt + " " + sendingTime;
    }

    public static void main(String[] args) {
        init();
        dijkstra();
        System.out.println(calcSendMessageTime());
    }
}
