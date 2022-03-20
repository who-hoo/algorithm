package programmers.level2;

/*
    문제    : 프로그래머스 H-Index
    유형    : 정렬
	난이도   : Hard (Level 2)
	시간    : 5h
	uri    : https://programmers.co.kr/learn/courses/30/lessons/42747
    날짜    : 22.03.20(o)
    refer  : https://ikjo.tistory.com/170
*/

import java.util.Arrays;

public class Programmers42747 {

    public static void main(String[] args) {
        Programmers42747 sol = new Programmers42747();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(sol.solution(citations));
    }

    public int solution(int[] citations) {
        int n = citations.length;
        for (int h = n; h >= 0; h--) {
            int finalH = h;
            long cnt = Arrays.stream(citations).filter(c -> c >= finalH).count();
            if (h <= cnt) {
                return h;
            }
        }
        return 0;
    }
}
