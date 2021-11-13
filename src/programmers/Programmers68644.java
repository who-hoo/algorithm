package programmers;

import java.util.*;

public class Programmers68644 {

    public static void main(String[] args) {
        Programmers68644 sol = new Programmers68644();
        int[] answers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(sol.solution(answers)));
    }

    public int[] solution(int[] numbers) {
        HashSet<Integer> calcSet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                calcSet.add(numbers[i] + numbers[j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
