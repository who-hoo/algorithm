package thisiscodingtest.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {

    int nodeA;
    int nodeB;
    int cost;

    public Edge(int nodeA, int nodeB, int cost) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost) {
            return -1;
        }
        return 1;
    }
}

public class Practice02 {

    static int n, m;
    static int[] parent;
    static ArrayList<Edge> edges;
    static int cost, last;

    static void init() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        edges = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a, b, c));
        }
        sc.close();
    }

    static int getRoot(int node) {
        if (node != parent[node]) {
            parent[node] = getRoot(parent[node]);
        }
        return parent[node];
    }

    static void union(int node1, int node2) {
        node1 = getRoot(node1);
        node2 = getRoot(node2);
        if (node1 < node2) {
            parent[node2] = node1;
        } else {
            parent[node1] = node2;
        }
    }

    static void kruskal() {
        Collections.sort(edges);
        for (Edge edge : edges) {
            if (getRoot(edge.nodeA) != getRoot(edge.nodeB)) {
                union(edge.nodeA, edge.nodeB);
                cost += edge.cost;
                last = edge.cost;
            }
        }
    }

    public static void main(String[] args) {
        init();
        kruskal();
        System.out.println(cost - last);
    }
}

/* sample input
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
*/
