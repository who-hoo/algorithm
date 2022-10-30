package goorm.challenge.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(in.readLine()); // 문자열의 길이
        final String s = in.readLine(); // 문자열(알파벳 소문자로만 구성)
        int answer = 1;
        char previousChar = s.charAt(0);
        for (char currentChar : s.toCharArray()) {
            if (previousChar != currentChar) {
                previousChar = currentChar;
                answer++;
            }
        }
        System.out.println(answer);
        in.close();
    }
}
