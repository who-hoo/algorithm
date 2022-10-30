package goorm.challenge.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q03 {

    private static List<int[]> permutations = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        permutation(numbers, 0, 4, 4);

        int answer = 0;
        for (int[] permutation : permutations) {
            answer = Math.max(answer, calculateDistance(permutation));
        }

        System.out.println(answer);
        br.close();
    }

    private static void permutation(int[] numbers, int depth, int n, int r) {
        if (depth == r) {
            permutations.add(numbers.clone());
        }

        for (int i = depth; i < n; i++) {
            swap(numbers, depth, i);
            permutation(numbers, depth + 1, n, r);
            swap(numbers, depth, i);
        }
    }

    private static void swap(int[] numbers, int depth, int i) {
        int temp = numbers[depth];
        numbers[depth] = numbers[i];
        numbers[i] = temp;
    }

    private static int calculateDistance(int[] numbers) {
        int x1 = numbers[0];
        int y1 = numbers[1];
        int x2 = numbers[2];
        int y2 = numbers[3];

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
