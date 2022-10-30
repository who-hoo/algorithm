package goorm.challenge.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q03 {

    static public class Person implements Comparable<Person> {

        private String name;
        private double height;

        public Person(String name, double height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Person other) {
            if (this.name.compareToIgnoreCase(other.name) == 0) {
                return Double.compare(this.height, other.height);
            }
            return this.name.compareToIgnoreCase(other.name);
        }

        @Override
        public String toString() {
            return String.format("%s %.2f", this.name, this.height);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        final int N = Integer.parseInt(inputs[0]); // 사람의 수
        final int k = Integer.parseInt(inputs[1]) - 1; // 찾아야 하는 수
        List<Person> persons = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            String[] personInfo = in.readLine().split(" ");
            String name = personInfo[0];
            double height = Double.parseDouble(personInfo[1]);
            persons.add(new Person(name, height));
        }
        Collections.sort(persons);
        System.out.println(persons.get(k));
        in.close();
    }
}
