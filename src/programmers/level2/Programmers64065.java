package programmers.level2;

/*
    문제    : 프로그래머스 튜플
    유형    :
	난이도   : SoSo (Level 2)
	시간    : 1h
	uri    : https://programmers.co.kr/learn/courses/30/lessons/64065
    날짜    : 22.05.02(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class Programmers64065 {

    class Element implements Comparable<Element> {

        int n;
        int count;

        Element(int n) {
            this.n = n;
            this.count = 1;
        }

        void addCount() {
            this.count++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Element element = (Element) o;
            return n == element.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n);
        }

        @Override
        public int compareTo(Element o) {
            if (count > o.count) {
                return -1;
            } else if (count == o.count) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public int[] solution(String s) {
        s = replacing(s);
        String[] split = s.split(",");
        HashSet<Element> set = new HashSet<>();
        ArrayList<Element> elements = new ArrayList<>();
        for (String str : split) {
            Element e = new Element(Integer.parseInt(str));
            if (set.add(e)) {
                elements.add(e);
            } else {
                int i = elements.indexOf(e);
                elements.get(i).addCount();
            }
        }
        Collections.sort(elements);
        return elements.stream()
            .map(e -> e.n)
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private String replacing(String s) {
        s = s.replace("{", "");
        s = s.replace("}", "");
        return s;
    }

    public static void main(String[] args) {
        Programmers64065 sol = new Programmers64065();
        String[] inputs = new String[]{
            "{{2},{2,1},{2,1,3},{2,1,3,4}}",
            "{{1,2,3},{2,1},{1,2,4,3},{2}}",
            "{{20,111},{111}}",
            "{{123}}",
            "{{4,2,3},{3},{2,3,4,1},{2,3}}"
        };
        for (String input : inputs) {
            System.out.println(Arrays.toString(sol.solution(input)));
        }
    }
}
