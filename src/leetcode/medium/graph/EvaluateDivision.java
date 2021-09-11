package leetcode.medium.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

   private static class Edge {

      String to;
      double value;

      Edge(String to, double value) {
         this.to = to;
         this.value = value;
      }

      @Override
      public String toString() {
         return "Edge{" +
             "to='" + to + '\'' +
             ", value=" + value +
             '}';
      }
   }

   public double dfs(String from, String to, Map<String, List<Edge>> edges, Set<String> visited) {

      if (!(edges.containsKey(from) && edges.containsKey(to))) {
         return -1;
      }
      if (from.equals(to)) {
         return 1;
      }
      visited.add(from);
      for (Edge edge : edges.get(from)) {
         if (!visited.contains(edge.to)) {
            double result = dfs(edge.to, to, edges, visited);
            if (result != -1) {
               return edge.value * result;
            }
         }
      }

      return -1;
   }

   public double[] calcEquation(List<List<String>> equations, double[] values,
       List<List<String>> queries) {
      Map<String, List<Edge>> edges = new HashMap<>();

      for (int i = 0; i < equations.size(); i++) {
         List<String> edge = equations.get(i);

         String from = edge.get(0);
         edges.putIfAbsent(from, new LinkedList<>());
         String to = edge.get(1);
         edges.putIfAbsent(to, new LinkedList<>());

         edges.get(from).add(new Edge(to, values[i]));
         edges.get(to).add(new Edge(from, 1 / values[i]));
      }

      double[] result = new double[queries.size()];
      Set<String> visited = new HashSet<>();

      for (int i = 0; i < queries.size(); i++) {
         List<String> query = queries.get(i);
         result[i] = dfs(query.get(0), query.get(1), edges, visited);
         visited.clear();
      }

      return result;
   }

   public static void main(String[] args) {

   }

}
