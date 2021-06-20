package codeforces.week1;

import java.util.Scanner;

public class DivideCheese {

   public static int gcd(int a, int b) {
      if (b == 0) {
         return a;
      }
      return gcd(b, a % b);
   }

   public static int countDivide(int x, int divider) {
      int counter = 0;

      while (true) {
         if (((double)x / 2) % divider == 0) {
            x = x / 2;
            counter++;
         } else if (((double)x / 3) % divider == 0) {
            x = x / 3;
            counter++;

         } else if (((double)x / 5) % divider == 0) {
            x = x / 5;
            counter++;
         } else {
            break;
         }
      }

      if (x != divider) {
         counter = -1;
      }

      return counter;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int a = scanner.nextInt();
      int b = scanner.nextInt();

      if(a == b){
         System.out.println("0");
         return;
      }

      int commonDivider = gcd(a, b);
      int resultA = countDivide(a, commonDivider);
      int resultB = countDivide(b, commonDivider);
      if (resultA == -1 || resultB == -1) {
         System.out.println("-1");
      } else {
         System.out.println(resultA + resultB);
      }
   }

}
