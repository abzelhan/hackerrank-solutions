package leetcode.medium.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindEventualSafeStates {

    private boolean dfs(Integer from, int[][] graph, int[] visited) {
        if (visited[from] == 1) {
            return true;
        } else if (visited[from] == 2) {
            return false;
        }

        visited[from] = 1;

        for (Integer vertex : graph[from]) {
            if (visited[vertex] == 1) {
                return true;
            } else if (visited[vertex] == 2) {
                continue;
            }

            boolean hasCycle = dfs(vertex, graph, visited);
            if (hasCycle) {
                return true;
            }
        }

        visited[from] = 2;

        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] edges) {
        List<Integer> result = new LinkedList<>();
        int[] visited = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (edges[i].length == 0) {
                result.add(i);
            } else {
                boolean hasCycle = dfs(i, edges, visited);

                if (!hasCycle) {
                    result.add(i);
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
