package codeforces.week1;

import java.util.HashSet;
import java.util.Scanner;

public class Laskutki {

   static class DSU {

      private int[] parents, ranks;
      public int size;

      public DSU(int n) {
         parents = new int[n];
         ranks = new int[n];
         size = n;
         for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
         }
      }

      public int findSet(int a) {
         if (a == parents[a]) {
            return a;
         }
         parents[a] = findSet(parents[a]);
         return parents[a];
      }

      public void unionSet(int a, int b) {
         a = findSet(a);
         b = findSet(b);
         if (a != b) {
            size--;
            if (ranks[a] < ranks[b]) {
               parents[a] = b;
            } else if (ranks[b] < ranks[a]) {
               parents[b] = a;
            } else {
               parents[b] = a;
               ranks[a]++;
            }
         }
      }


   }

   public static boolean isValid(int r1, int c1, int n, int m) {
      return (r1 < n && r1 >= 0 && c1 < m && c1 >= 0);
   }

   public static int getIndex(int r, int c, int m) {
      return r * m + c;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt(), m = scanner.nextInt();
      int[][] arr = new int[n][m];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = scanner.nextInt();
         }
      }

      int cntOfOnes = 0;
      DSU dsu = new DSU(n * m);
      int dr[] = {-1, 0, 1, 0};
      int dc[] = {0, 1, 0, -1};
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            if (arr[i][j] == 0) {
               int index = getIndex(i, j, m);
               for (int k = 0; k < 4; k++) {
                  int r1 = dr[k] + i;
                  int c1 = dc[k] + j;
                  if (isValid(r1, c1, n, m) && arr[r1][c1] == 0) {
                     int neighbourIndex = getIndex(r1, c1, m);
                     dsu.unionSet(neighbourIndex, index);
                  }
               }
            } else {
               cntOfOnes++;

            }
         }
      }
      System.out.println(dsu.size - cntOfOnes);
   }

}
