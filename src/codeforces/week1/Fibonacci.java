package codeforces.week1;

import java.util.Scanner;

public class Fibonacci {

   public static void main(String[] args) {
      int n = new Scanner(System.in).nextInt();

      long a = 1;
      long b = 1;
      long c = 0;

      for (int i = 0; i < n; i++) {
         if (i == 1 || i == 0) {
            c = 1;
         } else {
            c = (a + b);
            a = b;
            b = c;
         }
      }

      System.out.println(c);

   }

}
