package thisiscodingtest.graph;

import java.util.Scanner;

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
*/
public class Practice01 {

    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] parent;

    static void init() {
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    static void team() {
        for (int i = 0; i < m; i++) {
            int command = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (command == 0) {
                union(a, b);
            } else {
                System.out.println(isSameTeam(a, b) ? "YES" : "NO");
            }
        }
        sc.close();
    }

    static int getTeam(int a) {
        if (a != parent[a]) {
            parent[a] = getTeam(parent[a]);
        }
        return parent[a];
    }

    static boolean isSameTeam(int a, int b) {
        return getTeam(a) == getTeam(b);
    }

    static void union(int a, int b) {
        a = getTeam(a);
        b = getTeam(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        init();
        team();
    }
}
