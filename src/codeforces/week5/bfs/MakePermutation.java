package codeforces.week5.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MakePermutation {

   private static List<Integer> graph[];
   private static boolean visited[];
   private static Stack<Integer> stack;

   private static void dfs(int v) {

      visited[v] = true;

      for (Integer w : graph[v]) {
//         if (!visited[w]) {
            dfs(w);
//         }
      }

      stack.push(v);
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int v = scanner.nextInt();
      int e = scanner.nextInt();

      graph = new LinkedList[v + 1];
      visited = new boolean[v + 1];
      stack = new Stack<>();

      for (int i = 1; i <= v; i++) {
         graph[i] = new LinkedList<>();
      }

      scanner.nextLine();

      for (int i = 0; i < e; i++) {
         String[] equation = scanner.nextLine().split(" ");
         int v1 = Integer.parseInt(equation[0]);
         int v2 = Integer.parseInt(equation[2]);

         if (equation[1].equals("<")) {
            if (!(v1 < v2)) {
               graph[v2].add(v1);
            }
         } else {
            if (!(v1 > v2)) {
               graph[v1].add(v2);
            }
         }

      }

      for (int vertex = 1; vertex <= v; vertex++) {
         if (!visited[vertex]) {
            dfs(vertex);
         }
      }

      for (Integer element : stack) {
         System.out.print(element + " ");
      }


   }

}
