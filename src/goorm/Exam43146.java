package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam43146 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        String[] arrRows = new String[size];
        for (int i = 0; i < size; i++) {
            arrRows[i] = br.readLine();
        }
        String points = br.readLine();

        int[][] board = new int[size][size];
        for (int row = 0; row < size; row++) {
            String[] arrRow = arrRows[row].split(" ");
            for (int col = 0; col < size; col++) {
                board[row][col] = Integer.parseInt(arrRow[col]);
            }
        }

        String[] parsedPoints = points.split(" ");
        int startX = Integer.parseInt(parsedPoints[0]);
        int startY = Integer.parseInt(parsedPoints[1]);
        int endX = Integer.parseInt(parsedPoints[2]);
        int endY = Integer.parseInt(parsedPoints[3]);

        int result = 0;
        for (int row = startX; row <= endX; row++) {
            for (int col = startY; col <= endY; col++) {
                result += board[row][col];
            }
        }

        System.out.println(result);
    }
}
