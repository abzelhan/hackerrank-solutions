package codeforces.week5.graphs;

import java.io.PrintWriter;
import java.util.Scanner;

public class OriginsAndDrains {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int[][] matrix = new int[v][v];

      int e = scanner.nextInt();

      for (int i = 0; i < e; i++) {
         matrix[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
      }

      PrintWriter printWriter = new PrintWriter(System.out);

      int amountOfOrigins = 0;

      for (int i = 0; i < v; i++) {
         int counter = 0;
         for (int j = 0; j < v; j++) {
            counter += matrix[j][i];
         }
         if (counter == 0) {
            amountOfOrigins++;
            printWriter.append((i + 1) + " ");
         }
      }

      System.out.println(amountOfOrigins);
      printWriter.flush();
      System.out.println();

      int amountOfDrains = 0;

      for (int i = 0; i < v; i++) {
         int counter = 0;
         for (int j = 0; j < v; j++) {
            counter += matrix[i][j];
         }
         if (counter == 0) {
            amountOfDrains++;
            printWriter.append((i + 1) + " ");
         }
      }

      System.out.println(amountOfDrains);
      printWriter.flush();
      System.out.println();
   }

}
