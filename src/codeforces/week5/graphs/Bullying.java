package codeforces.week5.graphs;

import java.util.Scanner;

public class Bullying {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int n = scanner.nextInt();
      int[][] distance = new int[n][n];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            distance[i][j] = scanner.nextInt();
         }
         scanner.nextLine();
      }

      int minVal = Integer.MAX_VALUE;

      for (int k = 0; k < n; k++) {
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if (distance[i][k] + distance[k][j] + distance[i][j] < minVal) {
                  minVal = distance[i][j] + distance[i][k] + distance[k][j];
               }
            }
         }
      }

      System.out.println(minVal);

   }

}
