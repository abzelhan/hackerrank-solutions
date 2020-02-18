package algorithms.implementation.easy;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ElectronicsShop {

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxAmount = -1;
        int minAmount = -1;
        int moneySpent = -1;
        for (int i = 0; i < keyboards.length; i++) {
            int keyboardPrice = keyboards[i];
            for (int j = 0; j < drives.length; j++) {
                int drivePrice = drives[j];
                int totalSum = keyboardPrice + drivePrice;
                if (totalSum > maxAmount && totalSum <=b) {
                    maxAmount = totalSum;
                }
                if (minAmount == -1) {
                    minAmount = totalSum;
                } else if (totalSum < minAmount) {
                    minAmount = totalSum;
                }
            }
        }

        if (maxAmount <= b) {
            moneySpent = maxAmount;
        }

        return moneySpent;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] bnm = scanner.nextLine().split(" ");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        System.out.println(moneySpent);

        scanner.close();
    }
}
