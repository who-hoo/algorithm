package programmers;

import java.util.*;

public class Programmers12901 {

    public static void main(String[] args) {
        Programmers12901 sol = new Programmers12901();
        int a = 5;
        int b = 24;
        System.out.println(sol.solution(a, b));
    }

    public String solution(int a, int b) {
        final String[] DAY_OF_WEEK = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        Calendar date = Calendar.getInstance();
        date.set(2016, a - 1, b);
        date.get(Calendar.DAY_OF_WEEK);

        return DAY_OF_WEEK[date.get(Calendar.DAY_OF_WEEK)];
    }
}
