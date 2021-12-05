package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Exam43086 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();

        final int a = 'a';
        final int z = 'z';

        HashMap<Character, Integer> alphabetCnt = new HashMap<>();

        // alphabetCnt initialize
        for (int i = a; i <= z; i++) {
            alphabetCnt.put((char) i, 0);
        }

        for (int i = 0; i < input.length(); i++) {
            try {
                char alphabet= input.charAt(i);
                alphabetCnt.replace(alphabet, alphabetCnt.get(alphabet) + 1);
            } catch (Exception e) {
                // 해당하는 알파벳 없음
            }
        }

        alphabetCnt.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
