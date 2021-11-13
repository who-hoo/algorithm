package programmers;

import java.util.*;

public class Programmers12928 {

    public static void main(String[] args) {
        Programmers12928 sol = new Programmers12928();
        int n = 5;
        System.out.println(sol.solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}
