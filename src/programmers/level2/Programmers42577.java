package programmers.level2;

/*
    문제    : 프로그래머스 전화번호 목록
    유형    : 해시(인데 해시로 안풀음)
	난이도   : Easy (Level 2)
	시간    : 30m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/42577
    날짜    : 22.03.22(o)
    refer  :
*/

import java.util.Arrays;

public class Programmers42577 {

    public static void main(String[] args) {
        Programmers42577 sol = new Programmers42577();
        String[] case1 = new String[]{"119", "97674223", "1195524421"};
        String[] case2 = new String[]{"123", "456", "789"};
        String[] case3 = new String[]{"12", "123", "1235", "567", "88"};
        System.out.println(sol.solution(case1));
        System.out.println(sol.solution(case2));
        System.out.println(sol.solution(case3));
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
