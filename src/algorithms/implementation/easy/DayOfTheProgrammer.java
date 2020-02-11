package algorithms.implementation.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        if(year == 1918) return "26.09.1918";

        String result = "";

        if (year >= 1700 && year <= 1917) {
            if (year % 4 == 0) {
                result = "12.09." + year;
            } else {
                result = "13.09." + year;
            }
        } else if(year >= 1918 && year <= 2700){
            if (((year % 4) == 0 && (year % 100) != 0) || ((year % 4) == 0 && (year % 400) == 0)) {
                result = "12.09." + year;
            } else {
                result = "13.09." + year;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        System.out.println(result);

        bufferedReader.close();
    }
}

