package programmers;

import java.util.*;

public class Programmers12910 {

    public static void main(String[] args) {
        Programmers12910 sol = new Programmers12910();
        int[] arr = {3, 2, 6};
        int divisor = 10;
        System.out.println(Arrays.toString(sol.solution(arr, divisor)));
    }

    public int[] solution(int[] arr, int divisor) {
        int[] answer;

        if (divisor == 0) {
            answer = new int[]{-1};
            return answer;
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        Arrays.stream(arr)
            .filter(i -> i % divisor == 0)
            .sorted()
            .forEach(answerList::add);

        if (answerList.isEmpty()) {
            answer = new int[]{-1};
        } else {
            answer = new int[answerList.size()];
            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }
        }
        return answer;
    }
}
