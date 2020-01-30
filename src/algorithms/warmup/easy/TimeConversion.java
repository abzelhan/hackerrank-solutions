package algorithms.warmup.easy;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*
    URL: https://www.hackerrank.com/challenges/time-conversion/problem
 */
public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hour = Integer.valueOf(s.substring(0, s.indexOf(":")));
        String format = s.substring(s.length() - 2, s.length());
        if (hour == 12 && format.equals("AM")) {
            return "00" + s.substring(s.indexOf(":"), s.length() - 2);
        }
        if (hour != 12 && format.equals("PM")) {
            return (hour + 12) + s.substring(s.indexOf(":"), s.length() - 2);
        }
        return s.substring(0, s.length() -2);
    }

    private static final Scanner scan = new Scanner(System.in);

    /*
        Input:
        07:05:45PM
        Output:
        19:05:45

     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
