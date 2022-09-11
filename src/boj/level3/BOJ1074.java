package boj.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

    private static int r;
    private static int c;
    private static int sequence = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        final int N = Integer.parseInt(tokenizer.nextToken());
        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());
        int arraySize = (int) Math.pow(2, N);

        explore(N, 0, arraySize, 0, arraySize);
    }

    private static void explore(int n, int firstRow, int lastRow, int firstCol, int lastCol) {
        // N = 1인 경우, 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문
        if (n == 1) {
            visit(firstRow, lastRow, firstCol, lastCol);
            return;
        }

        // N > 1인 경우, 배열을 크기가 2^(N-1) * 2^(N-1)로 4등분 한 후에 재귀적으로 순서대로 방문한다.
        int middleRow = (firstRow + lastRow) / 2;
        int middleCol = (firstCol + lastCol) / 2;
        explore(n - 1, firstRow, middleRow, firstCol, middleCol); // 왼쪽 위
        explore(n - 1, firstRow, middleRow, middleCol, lastCol); // 오른쪽 위
        explore(n - 1, middleRow, lastRow, firstCol, middleCol); // 왼쪽 아래
        explore(n - 1, middleRow, lastRow, middleCol, lastCol); // 오른쪽 아래
    }

    private static void visit(int firstRow, int lastRow, int firstCol, int lastCol) {
        for (int row = firstRow; row < lastRow; row++) {
            for (int col = firstCol; col < lastCol; col++) {
                if (row == r && col == c) {
                    System.out.println(sequence);
                    System.exit(0);
                }
                sequence++;
            }
        }
    }
}
