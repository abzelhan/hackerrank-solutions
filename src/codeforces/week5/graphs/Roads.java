package codeforces.week5.graphs;

import java.util.Scanner;

public class Roads {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[][] arr = new int[n][n];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            arr[i][j] = scanner.nextInt();
         }
      }

      int counter = 0;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (arr[i][j] == arr[j][i] && arr[i][j] == 1) {
               counter++;
            }
         }
      }

      System.out.println(counter/2);
   }

}
