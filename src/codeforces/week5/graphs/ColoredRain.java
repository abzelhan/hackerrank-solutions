package codeforces.week5.graphs;

import java.util.Scanner;

public class ColoredRain {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      byte n = scanner.nextByte();
      byte arr[][] = new byte[n][n];

      for (byte i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            arr[i][j] = scanner.nextByte();
         }
      }

      byte colors[] = new byte[n];

      for (byte i = 0; i < n; i++) {
         colors[i] = scanner.nextByte();
      }

      short counter = 0;

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (arr[i][j] == arr[j][i] && arr[i][j] == 1 && colors[i] != colors[j]) {
               counter++;
            }
         }
      }

      System.out.println(counter / 2);
   }

}
