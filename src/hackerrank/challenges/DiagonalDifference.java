package hackerrank.challenges;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class DiagonalDifferenceResult {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int lToR = 0;
        int rToL = arr.size() - 1;
        int lDiagonal = 0;
        int rDiagonal = 0;
        for (int row = 0; row < arr.size(); row++) {
            List<Integer> currentRow = arr.get(row);
            lDiagonal += currentRow.get(lToR);
            rDiagonal += currentRow.get(rToL);
            lToR++;
            rToL--;
        }
        return Math.abs(lDiagonal - rDiagonal);
    }

}

public class DiagonalDifference {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifferenceResult.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
