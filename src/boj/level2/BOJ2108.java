package boj.level2;

/*
    문제    : BOJ 통계학
    유형    : 수학, 구현, 정렬
	난이도   : SoSo (Silver3)
	시간    : 1h
	uri    : https://www.acmicpc.net/problem/2108
    날짜    : 22.05.15(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class BOJ2108 {

    static int average(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return Math.round(sum / (float) numbers.length);
    }

    static int median(int[] numbers) {
        return numbers[numbers.length / 2];
    }

    static int maxFrequency(int[] numbers) {
        HashSet<Integer> check = new HashSet<>();
        LinkedList<int[]> counts = new LinkedList<>();
        for (int number : numbers) {
            if (check.add(number)) {
                int[] count = new int[]{number, 1};
                counts.add(count);
            } else {
                counts.getLast()[1]++;
            }
        }
        counts.sort((c1, c2) -> {
            if (c1[1] > c2[1]) {
                return -1;
            } else if (c1[1] < c2[1]) {
                return 1;
            } else {
                if (c1[0] < c2[0]) {
                    return -1;
                } else if (c1[0] > c2[0]) {
                    return 1;
                }
                return 0;
            }
        });
        if (numbers.length > 1 && counts.get(0)[1] == counts.get(1)[1]) {
            return counts.get(1)[0];
        }
        return counts.getFirst()[0];
    }

    static int range(int[] numbers) {
        return numbers[numbers.length - 1] - numbers[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(numbers);

        StringBuilder answer = new StringBuilder();
        answer.append(average(numbers)).append("\n")
            .append(median(numbers)).append("\n")
            .append(maxFrequency(numbers)).append("\n")
            .append(range(numbers));
        System.out.println(answer);
    }
}
