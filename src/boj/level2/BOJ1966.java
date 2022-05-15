package boj.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1966 {

    static class Document implements Comparable<Document> {

        int id;
        int priority;

        public Document(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        @Override
        public int compareTo(Document o) {
            if (this.priority > o.priority) {
                return -1;
            } else if (this.priority < o.priority) {
                return 1;
            } else {
                return 0;
            }
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

            PriorityQueue<Document> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.offer(new Document(i, Integer.parseInt(st.nextToken())));
            }

            int answer = 1;
            while (!pq.isEmpty()) {
                if (targetID == pq.poll().id) {
                    break;
                }
                answer++;
            }
            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }
}
