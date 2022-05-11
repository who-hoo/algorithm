package boj.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BOJ1931 {

    static class Conference implements Comparable<Conference> {

        int start;
        int end;
        int duration;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
            this.duration = end - start;
        }

        @Override
        public int compareTo(Conference o) {
            if (this.duration < o.duration) {
                return -1;
            } else if (this.duration == o.duration) {
                return Integer.compare(this.start, o.start);
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Conference{" +
                "start=" + start +
                ", end=" + end +
                ", duration=" + duration +
                '}';
        }
    }

    static HashSet<Integer> reservationTable = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의의 수
        ArrayList<Conference> conferences = new ArrayList<>(N);
        while (N-- > 0) {
            String[] times = br.readLine().split(" ");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);
            conferences.add(new Conference(startTime, endTime));
        }
        br.close();

        Collections.sort(conferences);

        int answer = 0;
        for (Conference conference : conferences) {
            if (canReserve(conference)) {
                System.out.println(conference);
                reserve(conference);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean canReserve(Conference conference) {
        for (int i = conference.start; i < conference.end; i++) {
            if (reservationTable.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private static void reserve(Conference conference) {
        for (int i = conference.start; i < conference.end; i++) {
            reservationTable.add(i);
        }
    }
}
