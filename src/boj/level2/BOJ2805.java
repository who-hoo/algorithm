package boj.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2805 {

    static int n, m;
    static ArrayList<Integer> trees;

    static int binarySearch(int start, int end) {
        int mid = (start + end) / 2;
        int sum = cut(mid);
        if (sum > m) {
            return binarySearch(mid+1, end);
        } else if (sum == m) {
            return mid;
        } else {
            return binarySearch(start, mid-1);
        }
    }

    static int cut(int h) {
        return trees.stream().filter(t -> t > h)
            .map(t -> t - h)
            .mapToInt(Integer::intValue)
            .sum();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 나무의 수
        m = Integer.parseInt(st.nextToken()); // 집으로 가져가려는 나무의 길이

        st = new StringTokenizer(br.readLine());
        trees = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Integer tree = Integer.valueOf(st.nextToken());
            trees.add(tree);
        }
        br.close();

        Collections.sort(trees);
        int answer = binarySearch(0, trees.get(n-1));
        System.out.println(answer);
    }
}
