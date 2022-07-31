package boj.level3;

/*
    문제    : BOJ 비밀번호 찾기
    유형    : 자료 구조, 해시를 사용한 집합과 맵
	난이도   : Easy (Silver4)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/17219
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class BOJ17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, String> memo = new HashMap<>(N);
        while (N-- > 0) {
            input = br.readLine().split(" ");
            String address = input[0];
            String password = input[1];
            memo.put(address, password);
        }

        while (M-- > 0) {
            bw.write(memo.get(br.readLine()));
            bw.write(System.lineSeparator());
        }

        bw.close();
        br.close();
    }
}
