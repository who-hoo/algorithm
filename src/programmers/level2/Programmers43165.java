package programmers.level2;

/*
	문제    : 프로그래머스 타겟 넘버
    유형    : 깊이/너비 우선 탐색(DFS/BFS)
	난이도   : Hard (Level 2)
	시간    : 1h 40m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/43165
    날짜    : 22.03.01(o)
    refer  : https://velog.io/@euneun/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%83%80%EA%B2%9F%EB%84%98%EB%B2%84C-BFSDFS
*/

public class Programmers43165 {

    public static void main(String[] args) {
        Programmers43165 sol = new Programmers43165();
        int[] numbers = new int[]{4, 1, 2, 1};
        int target = 4;
        System.out.println(sol.solution(numbers, target));
    }

    public static int count = 0;

    public void dfs(int depth, int total, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (total == target) {
                count++;
            }
            return;
        } else {
            dfs(depth + 1, total + numbers[depth], numbers, target);
            dfs(depth + 1, total - numbers[depth], numbers, target);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return count;
    }
}
