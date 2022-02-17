package boj.level2;

/*
	문제    : BOJ 단어 정렬
    유형    : 문자열, 정렬
	난이도   : Easy (Silver5)
	시간    : 20m
	uri    : https://www.acmicpc.net/problem/1181
    날짜    : 22.02.17(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class BOJ1181 {

    static class Word implements Comparable<Word> {

        String w;

        Word(String w) {
            this.w = w;
        }

        @Override
        public int compareTo(Word o) {
            if (this.w.length() != o.w.length()) {
                return this.w.length() - o.w.length();
            } else {
                return this.w.compareTo(o.w);
            }
        }

        @Override
        public String toString() {
            return w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Word word = (Word) o;
            return Objects.equals(w, word.w);
        }

        @Override
        public int hashCode() {
            return Objects.hash(w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Word> words = new HashSet<>();
        for (int i = 0; i < n; i++) {
            words.add(new Word(br.readLine()));
        }
        br.close();

        ArrayList<Word> wordList = new ArrayList(words);
        Collections.sort(wordList);

        for (Word word : wordList) {
            System.out.println(word);
        }
    }
}
