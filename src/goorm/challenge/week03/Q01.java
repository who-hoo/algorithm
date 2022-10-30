package goorm.challenge.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q01 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(in.readLine()); // 지인의 수
        StringTokenizer tokens = new StringTokenizer(in.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Integer.parseInt(tokens.nextToken());
        }
        System.out.println(answer);
        in.close();
    }
}
