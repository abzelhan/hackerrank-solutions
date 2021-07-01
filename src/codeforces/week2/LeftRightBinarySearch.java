package codeforces.week2;

import java.util.Scanner;

public class LeftRightBinarySearch {

   public static int lowerBound(int nums[], int target) {
      int l = 0, r = nums.length - 1;
      int ind = -1;
      while (l <= r) {
         int mid = (l + r) / 2;

         if (nums[mid] >= target) {
            r = mid - 1;
         } else {
            l = mid + 1;
         }

         if (nums[mid] == target) {
            ind = mid;
         }
      }

      return ind + 1;
   }

   public static int upperBound(int nums[], int target) {
      int l = 0, r = nums.length - 1;
      int ind = -1;
      while (l <= r) {
         int mid = (l + r) / 2;

         if (nums[mid] > target) {
            r = mid - 1;
         } else {
            l = mid + 1;
         }

         if (nums[mid] == target) {
            ind = mid;
         }
      }

      return ind + 1;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int m = scanner.nextInt();

      int nums[] = new int[n];
      int positions[] = new int[m];

      for (int i = 0; i < n; i++) {
         nums[i] = scanner.nextInt();
      }

      for (int i = 0; i < m; i++) {
         positions[i] = scanner.nextInt();
      }

      for (int i = 0; i < m; i++) {
         int lowerBound = lowerBound(nums, positions[i]);
         int upperBound = upperBound(nums, positions[i]);
         System.out.println(lowerBound == 0 && upperBound == 0 ? 0 : lowerBound + " " + upperBound);
      }
   }

}
