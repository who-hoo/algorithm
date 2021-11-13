package programmers;

import java.util.*;

public class Programmers42840 {

    public static void main(String[] args) {
        Programmers42840 sol = new Programmers42840();
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(sol.solution(answers)));
    }

    public int[] solution(int[] answers) {
        final int[] pattern1 = {1, 2, 3, 4, 5};
        final int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            if (pattern1[i % pattern1.length] == answers[i]) {
                count[0]++;
            }
            if (pattern2[i % pattern2.length] == answers[i]) {
                count[1]++;
            }
            if (pattern3[i % pattern3.length] == answers[i]) {
                count[2]++;
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        int max = Arrays.stream(count).max().getAsInt();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                answerList.add(i + 1);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
