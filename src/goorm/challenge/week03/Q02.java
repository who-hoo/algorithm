package goorm.challenge.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Q02 {

    public static void main(String[] args) throws IOException {

        final Map<Character, String> keys = Map.of(
            '1', "1.,?!",
            '2', "2ABC",
            '3', "3DEF",
            '4', "4GHI",
            '5', "5JKL",
            '6', "6MNO",
            '7', "7PQRS",
            '8', "8TUV",
            '9', "9WXYZ"
        );

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(in.readLine()); // 수열의 길이
        final char[] inputs = in.readLine().toCharArray();

        StringBuilder answer = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && inputs[i + 1] == inputs[i]) {
                count++;
            } else {
                count %= keys.get(inputs[i]).length();
                answer.append(keys.get(inputs[i]).charAt(count));
                count = 0;
            }
        }
        System.out.println(answer);
    }
}
