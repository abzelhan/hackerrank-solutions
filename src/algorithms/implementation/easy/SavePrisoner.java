package algorithms.implementation.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * URL: https://www.hackerrank.com/challenges/save-the-prisoner/problem
 * Input:
 * 2
 * 5 2 1
 * 5 2 2
 * Output:
 * 2
 * 3
 */
public class SavePrisoner {

    static int saveThePrisoner(int n, int m, int s) {
        int a = s+m-1;
        if(a>n){
            if(a%n==0){
                return n;
            }
            return a%n;
        }

        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            System.out.println(result);
        }

        scanner.close();
    }
}

