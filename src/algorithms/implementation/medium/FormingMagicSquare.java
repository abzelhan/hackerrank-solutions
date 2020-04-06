package algorithms.implementation.medium;

import java.io.IOException;
import java.util.Scanner;

public class FormingMagicSquare {


    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int magicNumber = -1;
        int temp = -1;
        for (int i = 0; i < s.length; i++) {
            int sum = 0;
            for (int j = 0; j < s[i].length; j++) {
                sum+=s[i][j];
            }
            if (magicNumber == -1) {
                magicNumber = sum;
            }

            if (sum != magicNumber) {
                temp = sum;
            }

        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);
        System.out.println(result);
        scanner.close();
    }
}

