package hackerrank.challenges;

import java.io.*;

/**
 * x1 < x2는 항상 참 만약 v1 보다 v2가 크다면 간격이 점점 벌어져 점점 따라잡을 수 없다. -> 참이 되려면 항상 v1 > v2조건을 만족
 * <p>
 * 캥거루 위치인 x2 - x1인 사이 거리를 점프거리 v1 - v2로 나눈 나머지가 0이라면 첫번째 캥거루가 따라잡을 수 있고 반복시 겹치는 곳이 생긴다.
 * <p>
 * 그 외의 경우는 전부 NO 반환.
 * <p>
 * 출처: https://sweetroute.tistory.com/entry/HackerRankKangaroo [치즈의 코딩]
 */
class KangarooResult {

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 > v2 && ((x2 - x1) % (v1 - v2)) == 0) {
            return "YES";
        }
        return "NO";
    }

}

public class Kangaroo {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = KangarooResult.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
