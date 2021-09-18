package leetcode.medium.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class LoudAndRich {

    private void dfs(int current, int from, LinkedList<Integer> graph[], int[] quietness, int[] vertex) {

        quietness[current] = quietness[from];
        vertex[current] = vertex[from];

        for (Integer child : graph[current]) {
            if (quietness[child] > quietness[current]) {
                dfs(child, from, graph, quietness, vertex);
            }
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] quietness = new int[quiet.length];
        int[] vertex = new int[quiet.length];
        LinkedList<Integer> graph[] = new LinkedList[quietness.length];

        for (int i = 0; i < quiet.length; i++) {
            graph[i] = new LinkedList<>();
            quietness[i] = quiet[i];
            vertex[i] = i;
        }

        for (int i = 0; i < richer.length; i++) {
            graph[richer[i][0]].add(richer[i][1]);
        }

        for (int i = 0; i < quiet.length; i++) {
            dfs(i, i, graph, quietness, vertex);
        }

        return vertex;
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
