package codeforces.week5;

import java.util.Scanner;

public class Loops {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();

      for (int i = 0; i < v; i++) {
         for (int j = 0; j < v; j++) {
            int val = scanner.nextInt();
            if (i == j & val == 1) {
               System.out.println("YES");
               return;
            }
         }
      }

      System.out.println("NO");

   }

}
