package leetcode.medium.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourceToTarget {

   public void dfs(List<Integer>[] graph, boolean[] visited, int from, int to,
       Stack<Integer> stack, List<List<Integer>> result) {

      if (from == to) {
         result.add(new LinkedList<>(stack));
         return;
      }

      visited[from] = true;

      for (Integer w : graph[from]) {
         if (!visited[w]) {
            stack.add(w);
            dfs(graph, visited, w, to, stack, result);
            stack.pop();
         }
      }

      visited[from] = false;
   }

   public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      List<List<Integer>> result = new LinkedList<>();

      List<Integer>[] adjacencyList = new LinkedList[graph.length];

      for (int i = 0; i < graph.length; i++) {
         adjacencyList[i] = new LinkedList<>();
      }

      for (int i = 0; i < graph.length; i++) {
         for (int j = 0; j < graph[i].length; j++) {
            adjacencyList[i].add(graph[i][j]);
         }
      }

      Stack<Integer> stack = new Stack<>();
      stack.push(0);
      dfs(adjacencyList, new boolean[graph.length], 0, graph.length - 1, stack, result);

      return result;
   }

   public static void main(String[] args) {
      new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
   }

}
