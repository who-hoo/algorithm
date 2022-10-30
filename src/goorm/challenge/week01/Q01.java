package goorm.challenge.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q01 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine()); // 섬의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 1;
        for (int i = 0; i < n; i++) {
            answer *= (Integer.parseInt(st.nextToken()));
        }

        System.out.println(answer);
        br.close();
    }
}
