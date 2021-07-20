package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphBFS {

   private List<Integer>[] graph;
   private boolean[] visited;
   private int[] distance;
   private int[] path;
   private Queue<Integer> queue;

   public DirectedGraphBFS(int v) {
      graph = new LinkedList[v];
      visited = new boolean[v];
      queue = new LinkedList<>();
      distance = new int[v];
      path = new int[v];
      for (int i = 0; i < v; i++) {
         graph[i] = new LinkedList<>();
      }
   }

   public void addEdge(int v, int w) {
      graph[v].add(w);
   }

   public void bfs(int source) {
      queue.add(source);
      visited[source] = true;
      distance[source] = 0;
      path[source] = source;

      while (!queue.isEmpty()) {
         Integer v = queue.poll();

         for (Integer w : graph[v]) {
            if (!visited[w]) {
               queue.add(w);
               visited[w] = true;
               distance[w] = distance[v] + 1;
               path[w] = v;
            }
         }
      }
   }

   public static void main(String[] args) {
      DirectedGraphBFS graphBFS = new DirectedGraphBFS(6);
      graphBFS.addEdge(0, 2);
      graphBFS.addEdge(0, 1);
      graphBFS.addEdge(2, 4);
      graphBFS.addEdge(4, 3);
      graphBFS.addEdge(3, 5);

      graphBFS.bfs(0);
      System.out.println();
   }

}
