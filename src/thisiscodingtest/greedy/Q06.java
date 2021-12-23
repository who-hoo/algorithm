package thisiscodingtest.greedy;

class Solution {

    public int solution(int[] food_times, long k) {
        int sec = 0;
        for (int food_time : food_times) {
            sec += food_time;
        }
        if (sec <= k) {
            return -1;
        }

        sec = 0;
        int i = 0;
        while (true) {
            if (i == food_times.length) {
                i = 0;
            }
            if (food_times[i] == 0) {
                i++;
                continue;
            }
            if (sec == k) {
                break;
            }
            food_times[i] -= 1;
            sec++;
            i++;
        }
        return i + 1;
    }
}

public class Q06 {

    public static void main(String[] args) {
        int[] food_times = new int[]{3, 1, 2};
        int k = 5;
        System.out.println(new Solution().solution(food_times, k));
    }
}
