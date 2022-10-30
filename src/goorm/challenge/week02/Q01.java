package goorm.challenge.week02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q01 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        final int t = Integer.parseInt(in.readLine()); // 시험의 개수
        for (int i = 0; i < t; i++) {
            final int n = Integer.parseInt(in.readLine()); // 응시 인원 수
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            List<Integer> scores = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                scores.add(Integer.parseInt(tokenizer.nextToken()));
            }
            double average = scores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
            long passCount = scores.stream()
                .mapToInt(Integer::intValue)
                .filter(s -> s >= average)
                .count();
            out.write(String.format("%d/%d", passCount, n));
            out.write(System.lineSeparator());
        }
        out.close();
        in.close();
    }
}
