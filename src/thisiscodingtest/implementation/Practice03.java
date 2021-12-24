package thisiscodingtest.implementation;

import java.util.Scanner;

public class Practice03 {

    public static boolean isValid(int n) {
        return 0 <= n && n < 8;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        sc.close();

        int col = input[0].toCharArray()[0] - 'a';
        int row = Integer.parseInt(input[1]) - 1;
        int cnt = 0;

        // 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동
        if (isValid(col - 2) && isValid(row - 1)) {
            cnt++;
        }
        if (isValid(col - 2) && isValid(row + 1)) {
            cnt++;
        }
        if (isValid(col + 2) && isValid(row - 1)) {
            cnt++;
        }
        if (isValid(col + 2) && isValid(row + 1)) {
            cnt++;
        }
        // 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동
        if (isValid(row - 2) && isValid(col - 1)) {
            cnt++;
        }
        if (isValid(row - 2) && isValid(col + 1)) {
            cnt++;
        }
        if (isValid(row + 2) && isValid(col - 1)) {
            cnt++;
        }
        if (isValid(row + 2) && isValid(col + 1)) {
            cnt++;
        }

        System.out.println(cnt);
    }
}
