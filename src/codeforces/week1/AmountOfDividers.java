package codeforces.week1;

import java.util.Scanner;

public class AmountOfDividers {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int counter = 0;
      for (int i = 1; i * i <= n; i++) {
         if (n % i == 0) {
            counter++;
            if (i * i != n) {
               counter++;
            }
         }
      }

      System.out.println(counter);
   }

}
