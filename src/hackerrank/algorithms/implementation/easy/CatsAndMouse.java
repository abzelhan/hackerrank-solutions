package hackerrank.algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

/*
    URL: https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 */
public class CatsAndMouse {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        int catADiff = x < z ? z - x : x - z;
        int catBDiff = y < z ? z - y : y - z;

        if (catADiff < catBDiff) {
            return "Cat A";
        } else if (catBDiff < catADiff) {
            return "Cat B";
        }
        return "Mouse C";
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
        Input:
        2
        1 2 3
        1 3 2
        Output:
        Cat B
        Mouse C
     */
    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);
            System.out.println(result);
        }

        scanner.close();
    }
}
