package programmers.level2;

/*
    문제    : 프로그래머스 두 큐 합 같게 만들기
    유형    :
	난이도   : Hard (Level 2)
	시간    : 30m
	uri    : https://school.programmers.co.kr/learn/courses/30/lessons/118667
    refer  : https://ikjo.tistory.com/318
*/

import java.util.LinkedList;
import java.util.Queue;

public class Programmers118667 {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        int answer = -1;
        int count = 0;
        long sum1 = q1.stream().mapToLong(Integer::longValue).sum();
        long sum2 = q2.stream().mapToLong(Integer::longValue).sum();
        while (true) {
            if (count > queue1.length * 2 + 2) {
                break;
            }
            if (sum1 == sum2) {
                answer = count;
                break;
            } else if (sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            } else if (sum1 < sum2){
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
            }
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] queue1 = {
            {3, 2, 7, 2},
            {1, 2, 1, 2},
            {1, 1}
        };
        int[][] queue2 = {
            {4, 6, 5, 1},
            {1, 10, 1, 2},
            {1, 5}
        };

        Programmers118667 sol = new Programmers118667();
        for (int i = 0; i < queue1.length; i++) {
            System.out.println(sol.solution(queue1[i], queue2[i]));
        }
    }
}
