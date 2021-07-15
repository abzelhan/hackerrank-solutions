package codeforces.week5.graphs;

import java.util.Scanner;

public class FullGraph {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int[][] matrix = new int[v][v];
      int e = scanner.nextInt();
      for (int i = 0; i < e; i++) {
         int a = scanner.nextInt() - 1;
         int b = scanner.nextInt() - 1;
         matrix[a][b] = 1;
         matrix[b][a] = 1;
      }

      for (int i = 0; i < v; i++) {
         for (int j = 0; j < v; j++) {
            if (!(i == j) && matrix[i][j] == matrix[j][i] && matrix[i][j] == 0) {
               System.out.println("NO");
               return;
            }
         }
      }

      System.out.println("YES");
   }

}
