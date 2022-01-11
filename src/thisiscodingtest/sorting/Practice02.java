package thisiscodingtest.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable {

    String name;
    int score;

    Student(String name, String score) {
        this.name = name;
        this.score = Integer.parseInt(score);
    }

    @Override
    public int compareTo(Object o) {
        Student compareStudent = (Student) o;
        return this.score - compareStudent.score;
    }
}

public class Practice02 {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            students.add(new Student(input[0], input[1]));
        }
        sc.close();

        Collections.sort(students);
        students.forEach(s -> System.out.print(s.name + " "));
    }
}
