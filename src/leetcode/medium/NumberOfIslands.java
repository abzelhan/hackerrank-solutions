package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

   public static class DSU {

      private int[] parent;
      private int[] rank;
      private Set<Integer> mergedLeaders;

      public DSU(int n) {
         parent = new int[n];
         rank = new int[n];
         mergedLeaders = new HashSet<>();

         for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
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

         if (rank[leaderP] > rank[leaderQ]) {
            parent[leaderQ] = leaderP;
            mergedLeaders.remove(leaderQ);
         } else if (rank[leaderP] < rank[leaderQ]) {
            parent[leaderP] = leaderQ;
            mergedLeaders.remove(leaderP);
         } else {
            parent[leaderQ] = leaderP;
            rank[leaderP]++;
            mergedLeaders.remove(leaderQ);
            mergedLeaders.add(leaderP);
         }
      }

      public void addSingleLeader(int p) {
         mergedLeaders.add(p);
      }

      public int getLeadersCount() {
         return mergedLeaders.size();
      }

   }

   public int getIndex(int row, int col, int cols) {
      return row * cols + col;
   }

   public boolean isValidIndex(int row, int col, int rows, int cols) {
      return (row >= 0 && col >= 0 && row < rows && col < cols);
   }

   public int numIslands(char[][] grid) {
      DSU dsu = new DSU(grid.length * grid[0].length);
      int[] dr = {-1, 1, 0, 0};
      int[] dc = {0, 0, 1, -1};
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == '1') {
               int position = getIndex(i, j, grid[i].length);
               boolean hasNeighbour = false;
               for (int k = 0; k < 4; k++) {
                  int ni = i + dr[k];
                  int nj = j + dc[k];

                  if (isValidIndex(ni, nj, grid.length, grid[i].length) && grid[ni][nj] == '1') {
                     int neighbourPosition = getIndex(ni, nj, grid[i].length);
                     dsu.union(neighbourPosition, position);
                     hasNeighbour = true;
                  }
               }
               if (!hasNeighbour) {
                  dsu.addSingleLeader(dsu.find(position));
               }
            }
         }
      }
      return dsu.getLeadersCount();
   }

   public static void main(String[] args) {

      char[][] grid = {
          {'1', '1', '0', '0', '0'},

          {'1', '1', '0', '0', '0'},
          {'0', '0', '1', '0', '0'},
          {'0', '0', '0', '1', '1'}};
      System.out.println(new NumberOfIslands().numIslands(grid));
   }

}
