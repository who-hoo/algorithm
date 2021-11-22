package hackerrank.challenges;

import java.io.*;

class TimeConversionResult {

    public static String timeConversion(String s) {
        boolean isPM = s.startsWith("PM", 8);
        String[] times = s.split(":");
        if (times[0].equals("12")) {
            times[0] = "00";
        }
        if (isPM) {
            times[0] = Integer.toString((Integer.parseInt(times[0]) + 12));
        }
        times[2] = times[2].substring(0, 2);
        return times[0] + ":" + times[1] + ":" + times[2];
    }

}

public class TimeConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
