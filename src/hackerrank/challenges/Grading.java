package hackerrank.challenges;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class GradingResult {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (Integer grade : grades) {
            int nextMultipleOf5 = (grade + 5) - (grade % 5);
            result.add((nextMultipleOf5 - grade < 3) && grade > 37 ? nextMultipleOf5 : grade);
        }

        return result;
    }
}

public class Grading {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = GradingResult.gradingStudents(grades);

        for (Integer grade : result) {
            System.out.println(grade);
        }

        bufferedReader.close();
    }
}
