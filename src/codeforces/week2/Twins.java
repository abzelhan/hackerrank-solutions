package codeforces.week2;

import java.util.Scanner;

public class Twins {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int arr[] = new int[n];

      int totalSum = 0;

      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
         totalSum += arr[i];
      }

      for (int i = 1; i < n; i++) {
         for (int j = i; j > 0; j--) {
            if (arr[j] > arr[j - 1]) {
               int temp = arr[j];
               arr[j] = arr[j - 1];
               arr[j - 1] = temp;
            }
         }
      }

      int sumLeft = 0;
      int counter = 0;

      for (int i = 0; i < n; i++) {
         if (sumLeft <= (totalSum - sumLeft)) {
            sumLeft += arr[i];
            counter++;
         } else {
            break;
         }
      }

      System.out.println(counter);
   }

}
