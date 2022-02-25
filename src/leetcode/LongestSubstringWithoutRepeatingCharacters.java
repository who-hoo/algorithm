package leetcode;

/*
	문제    : leetcode Longest Substring Without Repeating Characters
    유형    : Array and Strings
	난이도   : SoSo (medium)
	시간    : 1h 30m
	uri    : https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
    날짜    : 22.02.25(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        ArrayList<String> substrings = new ArrayList<>();
        char[] input = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        int currentIndex = 0;
        while (currentIndex < input.length) {
            if (charSet.add(input[currentIndex])) {
                sb.append(input[currentIndex]);
                currentIndex++;
            } else {
                substrings.add(sb.toString());
                sb.delete(0, sb.length());
                charSet.clear();
                currentIndex = ++startIndex;
            }
        }
        substrings.add(sb.toString());
        Collections.sort(substrings, (str1, str2) -> str2.length() - str1.length());
        return substrings.get(0).length();
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        int answer = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(answer);
    }
}
