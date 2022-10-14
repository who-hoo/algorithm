package programmers.level2;

/*
    문제    : 프로그래머스 파일명 정렬
    유형    :
	난이도   : Hard (Level 2)
	시간    : 1hr
	uri    : https://school.programmers.co.kr/learn/courses/30/lessons/17686
    refer  :
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers17686 {

    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>(files.length);
        for (String filename : files) {
            fileList.add(new File(filename));
        }

        return fileList.stream()
            .sorted()
            .map(File::toString)
            .toArray(String[]::new);
    }

    class File implements Comparable<File> {

        private String head;
        private String number;
        private String filename;

        File(String filename) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();

            for (char ch : filename.toCharArray()) {
                if (!Character.isDigit(ch) && number.length() == 0) {
                    head.append(ch);
                    continue;
                }
                if (Character.isDigit(ch) && number.length() <= 5) {
                    number.append(ch);
                    continue;
                }
                break;
            }

            this.head = head.toString();
            this.number = number.toString();
            this.filename = filename;
        }

        @Override
        public String toString() {
            return filename;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.equalsIgnoreCase(o.head)) {
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }
            return this.head.compareToIgnoreCase(o.head);
        }
    }

    public static void main(String[] args) {
        Programmers17686 sol = new Programmers17686();

        String[][] inputs = new String[][]{
            {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
            {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}
        };

        for (String[] input : inputs) {
            System.out.println(Arrays.toString(sol.solution(input)));
        }
    }
}
