package contest.week2;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

   /*
    * Complete the 'bfs' function below.
    *
    * The function is expected to return an INTEGER_ARRAY.
    * The function accepts following parameters:
    *  1. INTEGER n
    *  2. INTEGER m
    *  3. 2D_INTEGER_ARRAY edges
    *  4. INTEGER s
    */


   public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
      List<Integer>[] graph = new LinkedList[n];
      int[] distance = new int[n];
      s--;
      for (int i = 0; i < n; i++) {
         graph[i] = new LinkedList<>();
      }

      for (int i = 0; i < m; i++) {
         List<Integer> edge = edges.get(i);
         graph[edge.get(0) - 1].add(edge.get(1) - 1);
         graph[edge.get(1) - 1].add(edge.get(0) - 1);
      }

      Queue<Integer> queue = new LinkedList();

      boolean[] marked = new boolean[n];

      queue.add(s);
      marked[s] = true;
      distance[s] = 0;
      while (!queue.isEmpty()) {
         Integer vertex = queue.poll();

         for (Integer w : graph[vertex]) {
            if (!marked[w]) {
               marked[w] = true;
               distance[w] = distance[vertex] + 1;
               queue.add(w);
            }
         }
      }

      List<Integer> distances = new ArrayList<>();

      for (int i = 0; i < n; i++) {
         if (i != s) {
            if (!marked[i] || distance[i] == 0) {
               distances.add(-1);
            } else {
               distances.add(distance[i] * 6);
            }

         }
      }

      return distances;

   }

}

public class BFS {

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      int q = Integer.parseInt(bufferedReader.readLine().trim());

      IntStream.range(0, q).forEach(qItr -> {
         try {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "")
                .split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> edges = new ArrayList<>();

            IntStream.range(0, m).forEach(i -> {
               try {
                  edges.add(
                      Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                          .map(Integer::parseInt)
                          .collect(toList())
                  );
               } catch (IOException ex) {
                  throw new RuntimeException(ex);
               }
            });

            int s = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> result = Result.bfs(n, m, edges, s);

            System.out.println(
                result.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
                    + "\n");
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }
      });

      bufferedReader.close();
   }
}
