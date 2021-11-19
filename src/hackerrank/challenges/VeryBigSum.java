package hackerrank.challenges;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class VeryBigSumResult {

    public static long aVeryBigSum(List<Long> ar) {
        long result = 0;
        for (Long n : ar) {
            result += n;
        }
        return result;
    }

}

public class VeryBigSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long result = VeryBigSumResult.aVeryBigSum(ar);

        System.out.println(result);

        bufferedReader.close();
    }
}

