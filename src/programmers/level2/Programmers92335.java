package programmers.level2;

/*
	문제    : 프로그래머스 k진수에서 소수 개수 구하기
    유형    : 2022 KAKAO BLIND RECRUITMENT
	난이도   : Easy (Level 2)
	시간    : 1h 10m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/92335
    날짜    : 22.02.18(o)
    refer  :
*/

public class Programmers92335 {

    public static void main(String[] args) {
        Programmers92335 sol = new Programmers92335();
        int n = 437674;
        int k = 3;
        System.out.println(sol.solution(n, k));
    }

    public boolean isPrime(String number) {
        long n = Long.parseLong(number);
        if (n == 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        String converted = Integer.toString(n, k);
        int answer = 0;
        for (String number : converted.split("0")) {
            if (!number.isEmpty() && isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }
}
