package study.graph;

import java.util.Scanner;

public class DisjointSetsCycle {

    public static int root(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = root(parent, parent[node]);
        }
        return parent[node];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // 노드의 개수
        int e = sc.nextInt(); // 간선의 개수
        boolean isCycle = false;

        int[] parent = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            if (root(parent, node1) == root(parent, node2)) {
                isCycle = true;
                break;
            } else {
                node1 = root(parent, node1);
                node2 = root(parent, node2);
                if (node1 < node2) {
                    parent[node2] = node1;
                } else {
                    parent[node1] = node2;
                }
            }
        }

        System.out.println(isCycle ? "cycle" : "not cycle");
    }
}
