package goorm.challenge.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q04 {

    static int[] dRow = {0, -1, 0, 1, 0}; // 현재위치, 상, 우, 하, 좌
    static int[] dCol = {0, 0, 1, 0, -1}; // 현재위치, 상, 우, 하, 좌

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        final int n = Integer.parseInt(tokenizer.nextToken()); // 정사각형의 한 변의 길이
        final int k = Integer.parseInt(tokenizer.nextToken()); // 떨어트릴 폭탄의 개수
        int[][] map = new int[n][n];
        for (int i = 0; i < k; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            int row = Integer.parseInt(tokenizer.nextToken()) - 1;
            int col = Integer.parseInt(tokenizer.nextToken()) - 1;
            bomb(map, row, col);
        }

        int answer = 0;
        for (int[] row : map) {
            for (int col : row) {
                answer += col;
            }
        }
        System.out.println(answer);
        in.close();
    }

    private static void bomb(int[][] map, int row, int col) {
        for (int i = 0; i < 5; i++) {
            int r = row + dRow[i];
            int c = col + dCol[i];
            if (0 <= r && r < map.length &&
                0 <= c && c < map.length) {
                map[r][c]++;
            }
        }
    }
}
