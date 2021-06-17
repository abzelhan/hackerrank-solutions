package codeforces.week2;

import java.util.Arrays;
import java.util.Scanner;

public class SortBySums {

   private static int getSum(int n) {
      int sum = 0;
      while (n != 0) {
         sum += n % 10;
         n /= 10;
      }
      return sum;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      Integer arr[] = new Integer[n];
      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }

      for (int i = 1; i < arr.length; i++) {
         for (int j = i; j > 0; j--) {
            int sumOfLeft = getSum(arr[j]);
            int sumOfRight = getSum(arr[j - 1]);
            if (sumOfLeft < sumOfRight) {
               int temp = arr[j];
               arr[j] = arr[j - 1];
               arr[j - 1] = temp;
            } else if (sumOfLeft == sumOfRight) {
               if (arr[j] < arr[j - 1]) {
                  int temp = arr[j - 1];
                  arr[j - 1] = arr[j];
                  arr[j] = temp;
               }
            }
         }
      }

      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
   }

}
