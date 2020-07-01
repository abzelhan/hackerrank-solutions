package algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c, int k) {
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[(i + k) % c.length]);
        }
        return 0;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner("8 2\n" +
                "0 0 1 0 0 1 1 0");

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);
        System.out.println(result);

        scanner.close();
    }

}

