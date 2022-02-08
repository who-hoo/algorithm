package study.graph.spanningtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/* sample input
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
*/
public class Kruskal {

    public static int v, e, cost;
    public static int[] parents;
    public static ArrayList<Edge> edges;

    public static int getRoot(int node) {
        if (parents[node] != node) {
            parents[node] = getRoot(parents[node]);
        }
        return parents[node];
    }

    public static void union(int node1, int node2) {
        node1 = getRoot(node1);
        node2 = getRoot(node2);
        if (node1 < node2) {
            parents[node2] = node1;
        } else {
            parents[node1] = node2;
        }
    }

    public static void kruskal() {
        Collections.sort(edges);
        for (Edge edge : edges) {
            int node1 = edge.getNodeA();
            int node2 = edge.getNodeB();
            int dist = edge.getDistance();

            if (getRoot(node1) != getRoot(node2)) {
                union(node1, node2);
                cost += dist;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt(); // 노드의 개수
        e = sc.nextInt(); // 간선의 개수
        // init parents
        parents = new int[v + 1];
        for (int i = 0; i < v; i++) {
            parents[i] = i;
        }
        // init edges
        edges = new ArrayList<>(e);
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(a, b, cost));
        }
        sc.close();

        kruskal();

        System.out.println(cost);
    }
}
