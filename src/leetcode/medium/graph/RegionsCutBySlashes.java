package leetcode.medium.graph;

public class RegionsCutBySlashes {

   public boolean isValid(int i, int j, int rows, int cols) {
      return (i >= 0 && i < rows && j >= 0 && j < cols);
   }

   public void dfs(int i, int j, boolean[][] graph) {
      graph[i][j] = true;

      byte[] dx = {1, -1, 0, 0};
      byte[] dy = {0, 0, -1, 1};

      for (int k = 0; k < dx.length; k++) {
         if (isValid(i + dx[k], j + dy[k], graph.length, graph[0].length)
             && !graph[i + dx[k]][j + dy[k]]) {
            dfs(i + dx[k], j + dy[k], graph);
         }
      }

   }

   public int regionsBySlashes(String[] grid) {
      boolean[][] graph = new boolean[grid.length * 4][grid.length * 4];

      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length(); j++) {
            if (grid[i].charAt(j) == '\\') {
               for (int k = 0; k < 4; k++) {
                  graph[4 * i + k][4 * j + k] = true;
               }
            } else if (grid[i].charAt(j) == '/') {
               for (int k = 0; k < 4; k++) {
                  graph[4 * i + k][4 * j + 3 - k] = true;
               }
            }
         }
      }

      int counter = 0;

      for (int i = 0; i < graph.length; i++) {
         for (int j = 0; j < graph[0].length; j++) {
            if (!graph[i][j]) {
               dfs(i, j, graph);
               counter++;
            }
         }
      }

      return counter;
   }

   public static void main(String[] args) {
      System.out.println(new RegionsCutBySlashes().regionsBySlashes(new String[]{"//", "/ "}));
   }

}
