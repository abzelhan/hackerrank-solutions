package codeforces.week2;

import java.util.Scanner;

public class Dragons {

   static class Dragon {

      int force;
      int bonus;

      Dragon(int force, int bonus) {
         this.force = force;
         this.bonus = bonus;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int s = scanner.nextInt();
      int n = scanner.nextInt();
      Dragon[] dragons = new Dragon[n];
      for (int i = 0; i < n; i++) {
         dragons[i] = new Dragon(scanner.nextInt(), scanner.nextInt());
      }

      //sort dragons
      for (int i = 1; i < n; i++) {
         for (int j = i; j > 0; j--) {
            if (dragons[j].force < dragons[j - 1].force) {
               Dragon temp = dragons[j];
               dragons[j] = dragons[j - 1];
               dragons[j - 1] = temp;
            }
         }
      }

      for (int i = 0; i < n; i++) {
         if (s > dragons[i].force) {
            s += dragons[i].bonus;
         } else {
            System.out.println("NO");
            return;
         }
      }

      System.out.println("YES");
   }

}
