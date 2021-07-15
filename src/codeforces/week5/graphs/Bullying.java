package codeforces.week5.graphs;

import java.util.Arrays;
import java.util.Scanner;

public class Bullying {

   private static class Pair implements Comparable<Pair> {

      byte[] keys;
      short value;

      public Pair(byte[] keys, short value) {
         this.keys = keys;
         this.value = value;
      }

      @Override
      public int compareTo(Pair o) {
         return Integer.compare(value, o.value);
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      byte n = scanner.nextByte();

      short[][] arr = new short[n][n];

      for (byte i = 0; i < n; i++) {
         for (byte j = 0; j < n; j++) {
            arr[i][j] = scanner.nextShort();
         }
      }

      Pair[] pairs = new Pair[n * 2];
      int p = 0;
      for (byte i = 0; i < n; i++) {
         for (byte j = (byte) (i + 1); j < n; j++) {
            byte[] path = new byte[2];
            path[0] = (byte) (i + 1);
            path[1] = (byte) (j + 1);
            pairs[p++] = new Pair(path, arr[i][j]);
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }

      Arrays.sort(pairs);


      System.out.println();


   }

}
