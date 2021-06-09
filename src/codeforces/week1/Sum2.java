package codeforces.week1;

import java.util.Scanner;

public class Sum2 {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      int counter = 0;

      for (int a = 1; a <= n/4; a++) {
         for (int b = a; b <= n/3; b++) {
            for (int c = b; c <= n/2; c++) {
               int d = n - a - b - c;
               if (d >= c) {
                  counter++;
               }
            }
         }
      }

      System.out.println(counter);
   }

}
