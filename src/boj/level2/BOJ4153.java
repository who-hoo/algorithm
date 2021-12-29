package boj.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ4153 {

    public static boolean isPythagoras(ArrayList<Integer> numbers) {
        int a = numbers.get(0);
        int b = numbers.get(1);
        int c = numbers.get(2);
        return a * a + b * b == c * c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (!str.equals("0 0 0")) {
            String[] inputs = str.split(" ");
            ArrayList<Integer> numbers = new ArrayList<>();
            for (String input : inputs) {
                numbers.add(Integer.parseInt(input));
            }
            Collections.sort(numbers);
            System.out.println(isPythagoras(numbers) ? "right" : "wrong");
            str = sc.nextLine();
        }
        sc.close();
    }
}
