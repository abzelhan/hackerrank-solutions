package codeforces.week1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Subsequences {

   public static void main(String[] args) {
      int n = new Scanner(System.in).nextInt();

      for (int i = n + 1; i <= 10000; i++) {
         Set<Integer> numbers = new HashSet<>();
         int year = i;
         while (year != 0) {
            int reminder = year % 10;
            numbers.add(reminder);
            year /= 10;
         }
         if (numbers.size() == 4) {
            System.out.println(i);
            break;
         }
      }
   }

}
