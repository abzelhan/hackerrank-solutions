package codeforces.week2;

import java.util.Scanner;

public class BinarySearch {

   public static int search(int[] arr, int key) {
      int left = 0, right = arr.length - 1;

      while (left <= right) {
         int mid = (left + right) / 2;

         if (arr[mid] == key) {
            return mid;
         }

         if (arr[mid] < key) {
            left = mid + 1;
         } else {
            right = mid - 1;
         }

      }

      return -1;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int k = scanner.nextInt();

      int arr[] = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }
      for (int i = 0; i < k; i++) {
         int result = search(arr, scanner.nextInt());
         System.out.println(result > -1 ? "YES" : "NO");
      }
   }

}
