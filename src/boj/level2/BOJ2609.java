package boj.level2;

/*
    문제    : BOJ 최대공약수와 최소공배수
    유형    : 정렬
	난이도   : Easy (Silver5)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/2609
    날짜    : 22.03.23(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs = br.readLine().split(" ");
        int n1 = Integer.parseInt(inputs[0]);
        int n2 = Integer.parseInt(inputs[1]);
        br.close();

        int min = 0, max = 0, n = 1;
        while(true) {
            if (n1 % n == 0 && n2 % n == 0) {
                min = n;
            }
            if (n % n1 == 0 && n % n2 == 0) {
                max = n;
                break;
            }
            n++;
        }

        StringBuilder answer = new StringBuilder();
        answer.append(min)
            .append("\n")
            .append(max);
        bw.write(answer.toString());
        bw.close();
    }
}
