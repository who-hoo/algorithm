package leetcode;

public class ReverseInteger {

    public int reverse(int x) {
        StringBuilder str = new StringBuilder();
        if (x == 0) {
            str.append(0);
        }
        if (x < 0) {
            str.append("-");
            x *= -1;
        }
        while (x > 0) {
            str.append(x % 10);
            x /= 10;
        }
        try {
            return Integer.parseInt(String.valueOf(str));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-123));
    }
}
