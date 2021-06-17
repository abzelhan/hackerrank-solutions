package codeforces.week2;

import java.util.Scanner;

public class Tower {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      int[] bars = new int[n];

      for (int i = 0; i < n; i++) {
         bars[i] = scanner.nextInt();
      }

      for (int i = 1; i < n; i++) {
         for (int j = i; j > 0; j--) {
            if (bars[j] > bars[j - 1]) {
               int temp = bars[j];
               bars[j] = bars[j - 1];
               bars[j - 1] = temp;
            }
         }
      }

      int maxBars = 1;
      int towers = 1;

      int tempMaxBars = 1;
      for (int i = 0; i < n - 1; i++) {



         if (bars[i] == bars[i + 1]) {
            tempMaxBars++;
         } else {
            if (tempMaxBars > maxBars) {
               maxBars = tempMaxBars;
               tempMaxBars = 1;
            } else {
               tempMaxBars = 1;
            }
            towers++;
         }
      }

      if (tempMaxBars > maxBars) {
         maxBars = tempMaxBars;
      }
      System.out.println(maxBars + " " + towers);
   }

}
