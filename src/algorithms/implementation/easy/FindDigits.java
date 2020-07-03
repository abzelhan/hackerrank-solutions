package algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

public class FindDigits {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        int count = 0;
        while(n > 0){
            if(n % 10 != 0 && n % (n % 10) == 0) count++;
            n = n / 10;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            System.out.println(result);
        }

        scanner.close();
    }
}
