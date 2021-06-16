package algorithms.sorting;

import java.util.Scanner;

public class InsertionSort {

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
      Integer[] arr = new Integer[n];
      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }

      for (int i = 1; i < arr.length; i++) {
         for (int j = i; j > 0; j--) {
            if (less(arr[j], arr[j - 1])) {
               exchange(arr, j, j - 1);
            }
         }
      }

      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
   }

}
