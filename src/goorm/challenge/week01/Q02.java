package goorm.challenge.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int n = Integer.parseInt(input[0]); // 어떤 사람을 제외한 수업에 있는 사람의 수
        final String s = input[1]; // 어떤 사람의 이름

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String other = br.readLine();
            if (other.contains(s)) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
