package boj.level2;

/*
    문제    : BOJ 프린터 큐
    유형    : 구현, 자료 구조, 시뮬레이션, 큐
	난이도   : Easy (Silver3)
	시간    : 30m
	uri    : https://www.acmicpc.net/problem/1966
    날짜    : 22.05.16(o)
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {

    static class Document {

        int id;
        int priority;

        public Document(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int targetID = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서

            Queue<Document> queue = new LinkedList();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.offer(new Document(i, Integer.parseInt(st.nextToken())));
            }

            int answer = 0;
            while (!queue.isEmpty()) {
                int currentPriority = queue.peek().priority;
                if (queue.stream().anyMatch(d -> d.priority > currentPriority)) {
                    queue.offer(queue.poll());
                } else {
                    answer++;
                    if (targetID == queue.poll().id) {
                        break;
                    }
                }
            }
            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }
}
