package leetcode.medium.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindEventualSafeStates {

    private boolean dfs(Integer from, Map<Integer, List<Integer>> graph, int[] visited, List<Integer> result) {
        if (visited[from] == 1) {
            return true;
        } else if (visited[from] == 2) {
            return false;
        }

        visited[from] = 1;

        for (Integer vertex : graph.get(from)) {
            boolean hasCycle = dfs(vertex, graph, visited, result);
            if (hasCycle) {
                result.remove(vertex);
                return true;
            }
        }

        visited[from] = 2;

        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        int[] visited = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            LinkedList<Integer> vertices = new LinkedList<>();
            for (int j = 0; j < edges[i].length; j++) {
                vertices.add(edges[i][j]);
            }

            graph.put(i, vertices);
        }

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().isEmpty()) {
                result.add(entry.getKey());
            } else {
                boolean hasCycle = dfs(entry.getKey(), graph, visited, result);

                if (!hasCycle) {
                    result.add(entry.getKey());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindEventualSafeStates().eventualSafeNodes(
                new int[][]{
                        {1, 2},
                        {2, 3},
                        {5},
                        {0},
                        {5},
                        {},
                        {}}
        ));
    }

}
