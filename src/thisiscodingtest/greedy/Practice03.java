package thisiscodingtest.greedy;

import java.util.Scanner;

public class Practice03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }
        sc.close();

        int result = 1;
        for (int i = 0; i < n; i++) {
            int min = 10000;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
            if (result < min) {
                result = min;
            }
        }

        System.out.println(result);
    }
}
