package codeforces.week5.dfs;

import java.util.Scanner;

public class TraverseGraph {

   private int[][] graph;
   private boolean[] visited;

   public TraverseGraph(int v, int[][] matrix) {
      graph = matrix;
      visited = new boolean[v];
   }


   public void dfs(int v) {
      visited[v] = true;

      for (int i = 0; i < graph.length; i++) {
         if (!visited[i] && graph[v][i] == 1) {
            dfs(i);
         }
      }
   }

   public int connectivity() {
      int counter = 0;

      for (int i = 0; i < visited.length; i++) {
         if (visited[i]) {
            counter++;
         }
      }

      return counter;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int w = scanner.nextInt();

      int[][] matrix = new int[v][v];

      for (int i = 0; i < v; i++) {
         for (int j = 0; j < v; j++) {
            matrix[i][j] = scanner.nextInt();
         }
      }

      TraverseGraph traverseGraph = new TraverseGraph(v, matrix);
      traverseGraph.dfs(w - 1);

      System.out.println(traverseGraph.connectivity());

   }

}
