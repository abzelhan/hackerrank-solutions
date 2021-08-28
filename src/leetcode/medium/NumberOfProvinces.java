package leetcode.medium;

public class NumberOfProvinces {

   public void dfs(int v, int[][] graph, boolean[] visited) {
      visited[v] = true;

      for (int i = 0; i < graph.length; i++) {
         if (v != i && graph[v][i] == 1 && !visited[i]) {
            dfs(i, graph, visited);
         }
      }

   }

   public int findCircleNum(int[][] isConnected) {
      boolean[] visited = new boolean[isConnected.length];
      int counter = 0;
      for (int i = 0; i < isConnected.length; i++) {
         if (!visited[i]) {
            dfs(i, isConnected, visited);
            counter++;
         }
      }

      return counter;
   }

   public static void main(String[] args) {

   }

}
