package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Ineffective solution
 */
public class SurroundedRegions {

   public static class DSU {

      private int[] parent;
      private int[] rank;
      private Map<Integer, Set<Integer>> leaderWithPositions;

      public DSU(int n) {
         parent = new int[n];
         rank = new int[n];
         leaderWithPositions = new HashMap<>();

         for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
         }
      }

      public int find(int p) {
         if (p == parent[p]) {
            return p;
         }

         int oldLeader = parent[p];
         parent[p] = find(parent[p]);

         if (oldLeader != parent[p]) {
            if (leaderWithPositions.containsKey(oldLeader)) {
               leaderWithPositions.get(parent[p]).addAll(leaderWithPositions.get(oldLeader));
               leaderWithPositions.remove(oldLeader);
            }
         }

         return parent[p];
      }

      public void addNewLeader(int leader, int position) {
         if (!leaderWithPositions.containsKey(leader)) {
            Set<Integer> positions = new HashSet<>();
            positions.add(position);
            leaderWithPositions.put(leader, positions);
         } else {
            leaderWithPositions.get(leader).add(position);
         }
      }

      public void union(int p, int q) {
         int leaderP = find(p);
         int leaderQ = find(q);

         if (leaderP == leaderQ) {
            return;
         }

         if (rank[leaderP] > rank[leaderQ]) {
            parent[leaderQ] = leaderP;
            addNewLeader(leaderP, p);
            addNewLeader(leaderP, q);
         } else if (rank[leaderP] < rank[leaderQ]) {
            parent[leaderP] = leaderQ;
            addNewLeader(leaderQ, p);
            addNewLeader(leaderQ, q);
         } else {
            parent[leaderQ] = leaderP;
            rank[leaderP]++;
            addNewLeader(leaderP, p);
            addNewLeader(leaderP, q);

         }
      }

   }

   public int getIndex(int row, int col, int cols) {
      return row * cols + col;
   }

   public boolean isValidIndex(int row, int col, int rows, int cols) {
      return (row >= 0 && col >= 0 && row < rows && col < cols);
   }

   public boolean isOnBorder(int row, int col, int rows, int cols) {
      return row == 0 || col == 0 || row == rows - 1 || col == cols - 1;
   }

   public void solve(char[][] grid) {
      DSU dsu = new DSU(grid.length * grid[0].length);
      int[] dr = {-1, 1, 0, 0};
      int[] dc = {0, 0, 1, -1};
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 'O') {
               int position = getIndex(i, j, grid[i].length);

               boolean hasNeighbour = false;
               for (int k = 0; k < 4; k++) {
                  int ni = i + dr[k];
                  int nj = j + dc[k];

                  if (isValidIndex(ni, nj, grid.length, grid[i].length) && grid[ni][nj] == 'O') {
                     int neighbourPosition = getIndex(ni, nj, grid[i].length);
                     dsu.union(neighbourPosition, position);
                     if (isOnBorder(i, j, grid.length, grid[i].length)) {
                        dsu.leaderWithPositions.get(dsu.find(position)).add(-1);
                     }
                     if (isOnBorder(ni, nj, grid.length, grid[i].length)) {
                        dsu.leaderWithPositions.get(dsu.find(neighbourPosition)).add(-1);
                     }
                     hasNeighbour = true;
                  }
               }
               if (!hasNeighbour && !isOnBorder(i, j, grid.length, grid[i].length)) {
                  dsu.addNewLeader(dsu.find(position), position);
               }
            }
         }
      }

      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            for (Entry<Integer, Set<Integer>> entry : dsu.leaderWithPositions.entrySet()) {
               if (!entry.getValue().contains(-1) && entry.getValue()
                   .contains(getIndex(i, j, grid[i].length))) {
                  grid[i][j] = 'X';
               }
            }
         }
      }
   }

   public static void main(String[] args) {
      char[][] grid = {
          {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
          {'X', 'O', 'O', 'X', 'O', 'O', 'X'},
          {'X', 'X', 'O', 'X', 'O', 'X', 'X'},
          {'X', 'X', 'O', 'O', 'O', 'X', 'X'},
          {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
          {'X', 'O', 'X', 'X', 'X', 'X', 'X'},
          {'X', 'O', 'X', 'X', 'X', 'X', 'X'},
      };
      new SurroundedRegions().solve(grid);
   }

}
