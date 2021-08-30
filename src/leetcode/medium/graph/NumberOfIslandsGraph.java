package leetcode.medium.graph;

public class NumberOfIslandsGraph {

   public boolean isValid(int i, int j, int rows, int cols) {
      return (i >= 0 && i < rows && j >= 0 && j < cols);
   }

   public void dfs(int i, int j, char[][] graph, boolean[][] visited) {
      visited[i][j] = true;

      if (isValid(i + 1, j, visited.length, visited[0].length) && !visited[i + 1][j]
          && graph[i + 1][j] == '1') {
         dfs(i + 1, j, graph, visited);
      }

      if (isValid(i - 1, j, visited.length, visited[0].length) && !visited[i - 1][j]
          && graph[i - 1][j] == '1') {
         dfs(i - 1, j, graph, visited);
      }

      if (isValid(i, j - 1, visited.length, visited[0].length) && !visited[i][j - 1]
          && graph[i][j - 1] == '1') {
         dfs(i, j - 1, graph, visited);
      }

      if (isValid(i, j + 1, visited.length, visited[0].length) && !visited[i][j + 1]
          && graph[i][j + 1] == '1') {
         dfs(i, j + 1, graph, visited);
      }

   }

   public int numIslands(char[][] grid) {
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      int counter = 0;

      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1' && !visited[i][j]) {
               dfs(i, j, grid, visited);
               counter++;
            }
         }
      }

      return counter;
   }

   public static void main(String[] args) {

   }

}
