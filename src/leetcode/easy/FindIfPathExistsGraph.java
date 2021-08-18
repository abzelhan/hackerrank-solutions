package leetcode.easy;

import java.util.*;

public class FindIfPathExistsGraph {
   public boolean validPath(int n, int[][] edges, int start, int end) {
      List<Integer> graph [] = new LinkedList[n];

      for(int i = 0; i < n; i++) {
         graph[i] = new LinkedList<>();
      }

      for(int i = 0; i < edges.length; i++) {
         graph[edges[i][0]].add(edges[i][1]);
         graph[edges[i][1]].add(edges[i][0]);
      }


      Queue<Integer> queue = new LinkedList<>();
      boolean[] marked = new boolean[n];
      queue.add(start);
      marked[start] = true;

      while(!queue.isEmpty()) {
         int v = queue.poll();

         for(Integer w: graph[v]) {
            if(!marked[w]) {
               queue.add(w);
               marked[w] = true;
            }
         }

      }

      return marked[end];
   }
}
