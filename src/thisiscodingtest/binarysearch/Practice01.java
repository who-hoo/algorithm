package thisiscodingtest.binarysearch;

import java.util.*;

/* input
5
8 3 7 9 2
3
5 7 9
*/
public class Practice01 {

    public static boolean binarySearch(List<Integer> parts, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int middle = (start + end) / 2;
        if (parts.get(middle) == target) {
            return true;
        }
        int newStart = (target < parts.get(middle)) ? start : middle + 1;
        int newEnd = (target < parts.get(middle)) ? middle - 1 : end;
        return binarySearch(parts, target, newStart, newEnd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> parts = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            parts.add(sc.nextInt());
        }
        int m = sc.nextInt();
        ArrayList<Integer> asks = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            asks.add(sc.nextInt());
        }
        sc.close();

        Collections.sort(parts);

        for (int ask : asks) {
            boolean result = binarySearch(parts, ask, 0, parts.size() - 1);
            System.out.println(result ? "yes" : "no");
        }
    }
}
