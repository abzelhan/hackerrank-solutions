package leetcode.medium;

import java.util.Arrays;

public class MaxAreaOfIsland {

   public static class DSU {

      private int parent[];
      private int rank[];
      private int sum[];

      public DSU(int n) {
         parent = new int[n];
         rank = new int[n];
         sum = new int[n];
         for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            sum[i] = 0;
         }
      }

      public int find(int p) {
         if (p == parent[p]) {
            return p;
         }

         parent[p] = find(parent[p]);
         return parent[p];
      }

      public void union(int p, int q) {
         int leaderP = find(p);
         int leaderQ = find(q);

         if (leaderP == leaderQ) {
            return;
         }

         if(sum[leaderP] == 0) sum[leaderP]++;
         if(sum[leaderQ] == 0) sum[leaderQ]++;

         if (rank[leaderP] > rank[leaderQ]) {
            parent[leaderQ] = leaderP;
            sum[leaderP] += sum[leaderQ] ;
         } else if (rank[leaderP] < rank[leaderQ]) {
            parent[leaderP] = leaderQ;
            sum[leaderQ] += sum[leaderP]  ;
         } else {
            parent[leaderQ] = leaderP;
            sum[leaderP] += sum[leaderQ] ;
            rank[leaderP]++;
         }
      }

      public int getMaxSum(){
         Arrays.sort(sum);
         int sum = this.sum[this.sum.length - 1];
         return sum == 0 ? sum : sum ;
      }

      public void incrementSum(int p) {
         sum[find(p)]++;
      }

   }

   public static boolean isValidIndex(int i, int j, int rows, int cols) {
      return (i >= 0 && i < rows && j >= 0 && j < cols);
   }

   public static int getIndex(int i, int j, int cols) {
      return (i * cols) + j;
   }

   public int maxAreaOfIsland(int[][] grid) {
      DSU dsu = new DSU(grid.length * grid[0].length);

      int dr[] = {-1, 0, 1, 0};
      int dc[] = {0, 1, 0, -1};

      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {

            if (grid[i][j] == 1) {
               boolean isMerged = false;
               int index = getIndex(i, j, grid[i].length);
               for (int k = 0; k < 4; k++) {
                  int ki = dr[k] + i;
                  int kj = dc[k] + j;
                  if (isValidIndex(ki, kj, grid.length, grid[i].length) && grid[ki][kj] == 1) {
                     dsu.union(getIndex(ki, kj, grid[i].length), index);
                     isMerged = true;
                  }
               }

               if (!isMerged) {
                  dsu.incrementSum(index);
               }

            }
         }
      }

      return dsu.getMaxSum();
   }

   public static void main(String[] args) {
      int[][] arr =
          {   {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
              {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
              {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
              {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

      System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(arr));
      int [][] arr2 = {{0, 1, 1}};
      System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(arr2));
   }

}

