package thisiscodingtest.implementation;

import java.util.Scanner;

public class Practice01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] directions = sc.nextLine().split(" ");
        sc.close();

        int row = 1;
        int col = 1;
        for (String direction : directions) {
            switch (direction) {
                case "L":
                    if (col > 1) {
                        col--;
                    }
                    break;
                case "R":
                    if (col < n) {
                        col++;
                    }
                    break;
                case "U":
                    if (row > 1) {
                        row--;
                    }
                    break;
                case "D":
                    if (row < n) {
                        row++;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.printf("%d %d", row, col);
    }
}
