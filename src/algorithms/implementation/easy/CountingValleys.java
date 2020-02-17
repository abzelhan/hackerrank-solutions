package algorithms.implementation.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount = 0;
        int seaLevel = 0;

        boolean belowSeaLevel = false;

        for (int i = 0; i < n; i++) {
            char step = s.charAt(i);

            if (step == 'U') {
                ++seaLevel;
            } else if (step == 'D') {
                --seaLevel;
            }

            if (seaLevel < 0 ) {
                belowSeaLevel = true;
            } else if (seaLevel > 0) {
                belowSeaLevel = false;
            } else if (seaLevel == 0 && belowSeaLevel) {
                valleyCount++;
            }



        }

        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);
        scanner.close();
    }
}
