package goorm.challenge.week03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q04 {

    private static int N;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int finded = -1;
    private static List<List<Integer>> circles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        graph = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int node1 = Integer.parseInt(tokenizer.nextToken());
            int node2 = Integer.parseInt(tokenizer.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        in.close();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            List<Integer> circle = new ArrayList<>();
            findCircle(i, i, circle);
            circles.add(circle);
        }
    }

    private static void findCircle(int current, int target, List<Integer> circle) {
        if (visited[current]) {
            finded = current;
            if (!contains(circle, current)) {
                circle.add(current);
                return;
            }
        }
        visited[current] = true;
        for (int node : graph.get(current)) {
            if (node == target) {
                continue;
            }
            findCircle(node, node, circle);
            if (finded == -2) {
                return;
            }
            if (finded == current) {
                finded = -2;
                return;
            }
            if (finded >= 0 && !contains(circle, current)) {
                circle.add(current);
            }
        }
    }

    private static boolean contains(List<Integer> circle, int num) {
        return circle.stream()
            .anyMatch(node -> node == num);
    }

    private static void output() throws IOException {
        int maxCircleIndex = 0;
        for (int i = 0; i < circles.size(); i++) {
            if (circles.get(i).size() > circles.get(maxCircleIndex).size()) {
                maxCircleIndex = i;
            }
        }
        List<Integer> circle = circles.get(maxCircleIndex);
        Collections.sort(circle);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.append(String.valueOf(circle.size())).append(System.lineSeparator());
        for (int node : circle) {
            out.append(String.valueOf(node)).append(" ");
        }
        out.close();
    }
}
