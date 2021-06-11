package codeforces.week1;

import java.util.Scanner;

public class SubsequenceSum {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] reminders = new int[3];
      for (int i = 0; i < n; i++) {
         reminders[scanner.nextInt()%3]++;
      }
      System.out.println(Math.max(reminders[1], reminders[2]) + Math.min(1, reminders[0]));
   }

}
