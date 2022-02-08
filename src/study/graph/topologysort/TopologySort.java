package study.graph.topologysort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* sample input
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
*/
public class TopologySort {

    public static int v, e;
    public static ArrayList<Integer> inDegrees = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static Queue<Integer> q = new LinkedList<>();
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void init() {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt(); // 노드의 개수
        e = sc.nextInt(); // 간선의 개수
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
            inDegrees.add(0);
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            inDegrees.set(to, inDegrees.get(to) + 1);
        }
        sc.close();
    }

    public static void addZeroInDegree() {
        for (int i = 1; i < inDegrees.size(); i++) {
            if (inDegrees.get(i) == 0) {
                q.offer(i);
            }
        }
    }

    public static void sort() {
        addZeroInDegree();
        while (!q.isEmpty()) {
            int current = q.poll();
            result.add(current);
            for (int i = 0; i < graph.get(current).size(); i++) {
                int idx = graph.get(current).get(i);
                inDegrees.set(idx, inDegrees.get(idx) - 1);
                if (inDegrees.get(idx) == 0) {
                    q.offer(idx);
                }
            }
        }
    }

    public static void printResult() {
        for (Integer n : result) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        init();
        sort();
        printResult();
    }
}
