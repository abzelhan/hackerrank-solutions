package hackerrank.algorithms.search.medium;

import java.io.*;
import java.util.*;

/*
    URL: https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
 */
public class RadioTransmitters {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);

        int numOfTransmitters = 0;
        int i = 0;
        int n = x.length;

        while (i < n) {
            numOfTransmitters++;
            int loc = x[i] + k;
            while (i < n && x[i] <= loc){
                i++;
            }
            loc = x[--i] + k;
            while (i < n && x[i] <= loc){
                i++;
            }
        }

        return numOfTransmitters;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
        Input:
        5 1
        1 2 3 4 5
        Output:
        2
     */
    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        scanner.close();

        System.out.println(result);
    }
}

