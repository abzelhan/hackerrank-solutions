package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

public class DirectedGraphDFS {

   private List<Integer>[] graph;

   public DirectedGraphDFS(int v) {
      graph = new LinkedList[v];
      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
      }
   }

   public void link(int v, int w) {
      graph[v - 1].add(w);
   }

   public Iterable<Integer> outdegree(int v) {
      return graph[v - 1];
   }

   public void dfs(int v) {
      boolean[] marked = new boolean[graph.length];
      dfs(v, marked);
   }

   private void dfs(int v, boolean[] marked) {
      Iterable<Integer> vertex = outdegree(v);
      marked[v - 1] = true;

      for (Integer w : vertex) {
         if (!marked[w - 1]) {
            dfs(v, marked);
         }
      }
   }

   public static void main(String[] args) {

   }

}
