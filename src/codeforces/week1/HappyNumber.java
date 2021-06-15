package codeforces.week1;

import java.util.Scanner;

public class HappyNumber {

   public static void main(String[] args) {
      String word = new Scanner(System.in).nextLine();
      int counter4 = 0;
      int counter7 = 0;

      for (int i = 0; i < word.length(); i++) {
         if (word.charAt(i) == '4') {
            counter4++;
         } else if (word.charAt(i) == '7') {
            counter7++;
         }
      }

      if ((counter4 + counter7 == 4) ||
          (counter4 + counter7 == 7)) {
         System.out.println("YES");
      } else {
         System.out.println("NO");
      }
   }

}
