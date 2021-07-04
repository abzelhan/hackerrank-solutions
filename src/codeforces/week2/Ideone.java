package codeforces.week2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone {


   static Random random = new Random();

   public static void sort(int arr[], int l, int r) {
      if (l >= r) {
         return;
      }

      int pivotIndex = l + random.nextInt(r - l);

      int pivot = arr[pivotIndex];

      int i = l, j = r;

      while (i <= j) {

         while (arr[i] < pivot) {
            i++;
         }

         while (arr[j] > pivot) {
            j--;
         }

         if (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
         }


      }
      if (l < j) {
         sort(arr, l, j);
      }

      if (i < r) {
         sort(arr, i, r);
      }
   }

   public static void main(String[] args) throws java.lang.Exception {
      Scanner in = new Scanner(System.in);

      int m = in.nextInt();
      int n = in.nextInt();
      int[] a = new int[m];
      for (int i = 0; i < m; i++) {
         a[i] = in.nextInt();
      }
      sort(a, 0, m - 1);
      for (int i = 0; i < n; i++) {
         int b = in.nextInt();
         int lo = 0;
         int hi = m - 1;
         int ans = -1;
         while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] <= b) {
               lo = mid + 1;
               ans = mid;
            } else {
               hi = mid - 1;
               //ans = mid;
            }
         }
         System.out.println(ans + 1);
      }

   }
}
