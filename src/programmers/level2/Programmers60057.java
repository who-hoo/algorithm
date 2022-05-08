package programmers.level2;

/*
    문제    : 프로그래머스 문자열 압축
    유형    :
	난이도   : Hard (Level 2)
	시간    : 3h
	uri    : https://programmers.co.kr/learn/courses/30/lessons/60057
    날짜    : 22.05.04(o)
    refer  :
*/

public class Programmers60057 {

    public String compress(String s, int unit) {
        StringBuilder result = new StringBuilder();
        int cnt = 1;
        String prev = s.substring(0, unit);
        for (int i = unit; i < s.length(); i += unit) {
            try {
                String current = s.substring(i, i + unit);
                if (current.equals(prev)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        result.append(prev);
                    } else {
                        result.append(cnt).append(prev);
                    }
                    cnt = 1;
                    prev = current;
                }
            } catch (IndexOutOfBoundsException e) {
                if (cnt == 1) {
                    result.append(prev);
                } else {
                    result.append(cnt).append(prev);
                }
                result.append(s.substring(i));
                cnt = 1;
                prev = "";
            }
        }
        if (cnt == 1) {
            result.append(prev);
        } else {
            result.append(cnt).append(prev);
        }
        return result.toString();
    }

    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String compressed = compress(s, i);
            min = Math.min(min, compressed.length());
        }
        return min;
    }

    public static void main(String[] args) {
        Programmers60057 sol = new Programmers60057();
        String[] inputs = new String[]{
            "aabbaccc",
            "ababcdcdababcdcd",
            "abcabcdede",
            "abcabcabcabcdededededede",
            "xababcdcdababcdcd",
            "aaaaaaaaaaaabcd",
            "xxxxxxxxxxyyy",
            "aababa",
            "a",
            "abcabcdededededede",
            "xztjabcdabcd",
            "acdhdh",
            "abcabcdede", //8
            "werwerwsdgsdfsdfsdf", //15 -> 14
            "abcdabcd", //5
            "ab", //2
            "aaaccc", //4
            "aabbaccc", //7
            "ababcdcdababcdcd" //9
        };
        for (String input : inputs) {
            System.out.println(sol.solution(input));
        }
    }
}
