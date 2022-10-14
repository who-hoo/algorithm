package programmers.level2;

/*
    문제    : 프로그래머스 n진수 게임
    유형    :
	난이도   : Easy (Level 2)
	시간    : 20m
	uri    : https://school.programmers.co.kr/learn/courses/30/lessons/17687
    refer  :
*/

public class Programmers17687 {

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; temp.length() <= t * m; i++) {
            temp.append(Integer.toString(i, n));
        }

        for (int i = p; answer.length() < t; i+= m) {
            answer.append(temp.charAt(i - 1));
        }

        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Programmers17687 sol = new Programmers17687();

        int[] n = new int[]{2, 16, 16};
        int[] t = new int[]{4, 16, 16};
        int[] m = new int[]{2, 2, 2};
        int[] p = new int[]{1, 1, 2};

        for (int i = 0; i < n.length; i++) {
            System.out.println(sol.solution(n[i], t[i], m[i], p[i]));
        }
    }
}
