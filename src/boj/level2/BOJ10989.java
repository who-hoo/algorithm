package boj.level2;

/*
    문제    : BOJ 수 정렬하기 3
    유형    : 정렬
	난이도   : Easy (Silver5)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/10989
    날짜    : 22.03.23(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int integer : arr) {
            sb.append(integer).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
