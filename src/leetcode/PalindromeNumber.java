package leetcode;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(-101));
    }
}
