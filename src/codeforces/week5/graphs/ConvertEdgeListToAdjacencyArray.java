package codeforces.week5.graphs;

import java.util.Scanner;

public class ConvertEdgeListToAdjacencyArray {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int e = scanner.nextInt();

      int[][] matrix = new int[v][v];

      for (int i = 0; i < e; i++) {
         int a = scanner.nextInt() - 1;
         int b = scanner.nextInt() - 1;

         matrix[a][b] = 1;
         matrix[b][a] = 1;
      }

      for (int i = 0; i < v; i++) {
         for (int j = 0; j < v; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
   }

}
