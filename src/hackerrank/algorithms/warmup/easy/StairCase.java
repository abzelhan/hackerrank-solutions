package hackerrank.algorithms.warmup.easy;

import java.util.*;

/*
    Url: https://www.hackerrank.com/challenges/staircase/problem
 */
public class StairCase {

    // Complete the staircase function below.
    static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n - i - 1; j++) {
                line += " ";
            }
            int index = n -i -1;
            for (int j = index; j < n; j++) {
                line += "#";
            }
            System.out.println(line);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
    Sample input:
    6
    Sample output:
          #
         ##
        ###
       ####
      #####
     ######
     */
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}

