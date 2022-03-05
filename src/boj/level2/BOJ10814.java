package boj.level2;

/*
	문제    : BOJ 나이순 정렬
    유형    : 정렬
	난이도   : Easy (Silver5)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/10814
    날짜    : 22.03.05(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class User {

    int age;
    String name;

    public User(String input) {
        String[] args = input.split(" ");
        this.age = Integer.parseInt(args[0]);
        this.name = args[1];
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class BOJ10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        User[] users = new User[n];
        for (int i = 0; i < n; i++) {
            users[i] = new User(br.readLine());
        }
        br.close();

        Arrays.sort(users, (u1, u2) -> {
            if (u1.age < u2.age) {
                return -1;
            }
            if (u1.age == u2.age) {
                return 0;
            }
            return 1;
        });

        for (User user : users) {
            System.out.println(user);
        }
    }
}
