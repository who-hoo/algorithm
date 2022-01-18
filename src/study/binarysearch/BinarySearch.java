package study.binarysearch;

public class BinarySearch {

    public static int[] numbers = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};

    public static int binary_search(int target, int[] numbers, int start, int end) {
        int middle = (start + end) / 2;
        int result;
        if (numbers[middle] == target) {
            result = middle;
        } else {
            int newStart = (target < numbers[middle]) ? start : middle + 1;
            int newEnd = (target < numbers[middle]) ? middle - 1 : end;
            result = binary_search(target, numbers, newStart, newEnd);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binary_search(6, numbers, 0, numbers.length - 1) + 1);
    }
}
