package boj.level2;

/*
    문제    : BOJ 덩치
    유형    : 구현, 브루트포스 알고리즘
	난이도   : Easy (Silver5)
	시간    : 10m
	uri    : https://www.acmicpc.net/problem/7568
    날짜    : 22.04.01(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ7568 {

    static class Person {

        int weight;
        int height;

        Person(String line) {
            String[] s = line.split(" ");
            this.weight = Integer.parseInt(s[0]);
            this.height = Integer.parseInt(s[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(br.readLine());
        }
        br.close();

        StringBuilder answer = new StringBuilder();
        for (Person person : people) {
            int count = 0;
            for (Person other : people) {
                if (person.height < other.height && person.weight < other.weight) {
                    count++;
                }
            }
            answer.append(count + 1).append(" ");
        }

        System.out.println(answer);
    }
}
