package thisiscodingtest.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice01 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        sc.close();

        Collections.sort(numbers, Collections.reverseOrder());
        numbers.forEach(number -> System.out.print(number + " "));
    }
}
