package codeforces.week1;

import java.util.Scanner;

public class Fibonacci {

   public static void main(String[] args) {
      int n = new Scanner(System.in).nextInt();

      double root5 = Math.sqrt(5);
      double gr = ((1.0 + root5)) / 2.0;
      double igr = 1.0 - gr;

      double value = (Math.pow(gr, n) - Math.pow(igr, n)) / root5;
      System.out.println(value);
      double result = Math.floor(value + 0.5);

      System.out.println((long) result%10);
   }

}
