package codeforces.week2;

import java.util.Scanner;

public class MinimunToFirst {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      int arr[] = new int[n];
      int minIndex = -1;
      int minVal = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
         if (arr[i] < minVal) {
            minIndex = i;
            minVal = arr[i];
         }
      }

      int temp = arr[0];
      arr[0] = arr[minIndex];
      arr[minIndex] = temp;

      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
   }

}
