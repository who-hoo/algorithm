package boj.level2;

import java.util.*;

public class BOJ1920 {

    public static HashSet<Integer> numbers = new HashSet<>();
    public static ArrayList<Integer> targets = new ArrayList<>();

    public static int search(int target) {
        return (numbers.add(target)) ? 0 : 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            targets.add(sc.nextInt());
        }
        sc.close();

        for (int target : targets) {
            System.out.println(search(target));
        }
    }
}
