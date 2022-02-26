package boj.level2;

/*
	문제    : BOJ 수 정렬하기 2
    유형    : 정렬
	난이도   : Easy (Silver5)
	시간    : 30m
	uri    : https://www.acmicpc.net/problem/2751
    날짜    : 22.02.26(o)
    refer  : https://codeung.tistory.com/130?category=449370

    출력을 n줄로 해야하기 때문에 System.out.println()을 쓰면 시간초과가 발생한다.
    입출력에 주의하자.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
