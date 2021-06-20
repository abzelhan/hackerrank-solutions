package codeforces.week2;

import java.util.Scanner;

public class CloseBinarySearch {

   public static int lowerBound(int arr[], int key) {
      int left = 0, right = arr.length - 1;
      int result = -1;
      while (left <= right) {
         int mid = (left + right) / 2;

         if (key < arr[mid]) {
            result = mid;
            right = mid - 1;
         } else {
            left = mid + 1;
         }

      }

      return result;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int k = scanner.nextInt();

      int arr[] = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }

      for (int i = 0; i < k; ++i) {
         int x = scanner.nextInt();
         int lowerBound = lowerBound(arr, x);
         if (lowerBound == -1) {
            System.out.println(arr[arr.length - 1]);
         } else if (lowerBound == 0) {
            System.out.println(arr[0]);
         } else if (x - arr[lowerBound - 1] <= arr[lowerBound] - x) {
            System.out.println(arr[lowerBound - 1]);
         } else {
            System.out.println(arr[lowerBound]);
         }
      }
   }

}
