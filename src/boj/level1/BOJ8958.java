package boj.level1;

import java.util.Scanner;

public class BOJ8958 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = Integer.parseInt(sc.nextLine());
        String[] inputs = new String[caseCnt];
        for (int i = 0; i < caseCnt; i++) {
            inputs[i] = sc.nextLine();
        }
        sc.close();

        for (String input : inputs) {
            int score = 0;
            int combo = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'O') {
                    combo++;
                    score += combo;
                } else {
                    combo = 0;
                }
            }
            System.out.println(score);
        }
    }
}
