package codeforces.week5.graphs;

import java.util.Scanner;

public class CheckForUndirected {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      byte n = scanner.nextByte();

      byte[][] arr = new byte[n][n];

      for (byte i = 0; i < n; i++) {
         for (byte j = 0; j < n; j++) {
            arr[i][j] = scanner.nextByte();
         }
      }
      for (byte i = 0; i < n; i++) {
         for (byte j = 0; j < n; j++) {
            if (arr[i][j] != arr[j][i]) {
               System.out.println("NO");
               return;
            }
         }
      }

      System.out.println("YES");
   }

}
