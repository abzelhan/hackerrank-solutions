package codeforces.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DivideArray {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int arr[] = new int[n];
      int pos[] = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = scanner.nextInt();
      }
      for (int i = 0; i < n; i++) {
         pos[i] = scanner.nextInt();
      }

      for (int i = 0; i < n; i++) {
         arr[pos[i] - 1] = -1;

         List<Integer> sums = new ArrayList<>();

         int sum = 0;
         for (int j = 0; j < n; j++) {
            if (arr[j] != -1) {
               sum += arr[j];
            } else {
               sums.add(sum);
               sum = 0;
            }
         }
         sums.add(sum);
         System.out.println(Collections.max(sums));
      }
   }

}
