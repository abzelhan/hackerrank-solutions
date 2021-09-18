package leetcode.medium.graph;

import java.util.*;

public class LoudAndRich {

    private static class Edge implements Comparable<Edge> {
        private int vertex;
        private int quietness;

        public Edge(int vertex, int quietness) {
            this.vertex = vertex;
            this.quietness = quietness;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(quietness, o.quietness);
        }
    }

    private void dfs(int current, Edge from, LinkedList<Integer> graph[], Set<Integer> visited, Edge[] quietness) {
        visited.add(current);
        if(quietness[current].quietness > quietness[from.vertex].quietness) {
            quietness[current] = quietness[from.vertex];
        }
        if(quietness[current].quietness > quietness[from.vertex].quietness) {
            quietness[current] = quietness[from.vertex];
        }
        for (Integer child : graph[current]) {
            if (!visited.contains(child)) {
                dfs(child, from, graph, visited, quietness);
            }
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        PriorityQueue<Edge> sortedEdges = new PriorityQueue<>();
        LinkedList<Integer> graph[] = new LinkedList[quiet.length];
        Set<Integer> visited = new HashSet<>();
        Edge[] result = new Edge[quiet.length];

        for (int i = 0; i < quiet.length; i++) {
            Edge edge = new Edge(i, quiet[i]);
            sortedEdges.add(edge);
            graph[i] = new LinkedList<>();
            result[i] = edge;
        }

        for (int i = 0; i < richer.length; i++) {
            graph[richer[i][0]].add(richer[i][1]);
        }

        while (!sortedEdges.isEmpty()) {
            Edge edge = sortedEdges.poll();
            dfs(edge.vertex, edge, graph, visited, result);
            visited.clear();
        }

        return Arrays.stream(result).mapToInt(e -> e.vertex).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LoudAndRich().loudAndRich(
                new int[][]
                        {
                                {1, 0},
                                {2, 1},
                                {3, 1},
                                {3, 7},
                                {4, 3},
                                {5, 3},
                                {6, 3}
                        },
                new int[]{3, 2, 5, 4, 6, 1, 7, 0}
        )));
    }

}
