package programmers;

import java.util.*;

public class Programmers64061 {

    public static void main(String[] args) {
        Programmers64061 sol = new Programmers64061();
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(sol.solution(board, moves));
    }

    public static int pick(int[][] board, int move) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][move - 1] != 0) {
                int dollType = board[i][move - 1];
                board[i][move - 1] = 0;
                return dollType;
            }
        }
        return 0;
    }

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            int doll = pick(board, move);
            if (doll > 0) {
                basket.push(doll);
                if (basket.size() < 2) {
                    continue;
                }
                int lastIndexOfBasket = basket.size() - 1;
                if (basket.get(lastIndexOfBasket).equals(basket.get(lastIndexOfBasket - 1))) {
                    basket.pop();
                    basket.pop();
                    answer += 2;
                }
            }
        }

        return answer;
    }
}
