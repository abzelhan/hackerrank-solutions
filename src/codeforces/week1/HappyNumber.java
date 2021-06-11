package codeforces.week1;

import java.util.Scanner;

public class HappyNumber {

   public static void main(String[] args) {
      String word = new Scanner(System.in).nextLine();

      if (!(word.contains("4") && word.contains("7"))) {
         System.out.println("NO");
         return;
      }

      for (int i = 0; i < word.length(); i++) {
         if (word.charAt(i) == '4' || word.charAt(i) == '7') {
            continue;
         } else {
            System.out.println("NO");
            return;
         }
      }

      System.out.println("YES");
   }

}
