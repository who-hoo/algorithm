package leetcode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        int minLength = strs[0].length();
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        outer:
        while (i < minLength) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    break outer;
                }
            }
            sb.append(ch);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
