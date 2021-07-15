package codeforces.week5.graphs;

import java.util.Scanner;

public class ConvertFromAdjacenctMatrixToEdgeList {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      byte[][] matrix = new byte[v][v];

      for (int i = 0; i < v; i++) {
         for (int j = 0; j < v; j++) {
            matrix[i][j] = scanner.nextByte();
         }
      }

      int counter = 0;
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < v; i++) {
         for (int j = i + 1; j < v; j++) {
            if (matrix[i][j] == 1) {
               counter++;
               builder.append((i + 1) + " " + (j + 1) + "\n");
            }
         }
      }

      System.out.println(counter);
      System.out.print(builder);

   }

}
