package codeforces.week2;

import java.util.Scanner;

public class SortFromLToR {

   private static boolean less(Comparable a, Comparable b) {
      return a.compareTo(b) < 0;
   }

   private static void exchange(Comparable arr[], int i, int j) {
      Comparable temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      Integer arr[] = new Integer[n];
      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }

      int l = scanner.nextInt();
      int r = scanner.nextInt();

      for (int i = l; i <= r; i++) {
         for (int j = i; j > l; j--) {
            if (less(arr[j], arr[j - 1])) {
               exchange(arr, j, j-1);
            }
         }
      }

      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
   }

}
