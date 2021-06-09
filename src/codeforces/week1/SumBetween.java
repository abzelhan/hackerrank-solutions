package codeforces.week1;

import java.util.Scanner;

public class SumBetween {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      long result = 0;

      if (n > 0) {
         result = (n * (n + 1L)) / 2L;
      } else if (n < 1) {
         result = ((-n * (n - 1L)) / 2L) + 1L;
      }


      System.out.println(result);
   }

}
