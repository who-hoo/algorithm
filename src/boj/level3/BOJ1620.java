package boj.level3;

/*
    문제    : BOJ 나는야 포켓몬 마스터 이다솜
    유형    : 자료 구조, 해시를 사용한 집합과 맵
	난이도   : Easy (Silver4)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/1620
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class BOJ1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, String> dict = new HashMap<>(2 * N);
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            String number = String.valueOf(i);
            dict.put(name, number);
            dict.put(number, name);
        }

        while (M-- > 0) {
            bw.write(dict.get(br.readLine()) + "\n");
        }

        bw.close();
        br.close();
    }
}
