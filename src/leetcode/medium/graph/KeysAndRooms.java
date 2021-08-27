package leetcode.medium.graph;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class KeysAndRooms {

   public void dfs(int v, List<List<Integer>> rooms, boolean visited[], AtomicInteger counter) {
      visited[v] = true;
      counter.incrementAndGet();

      for (Integer w : rooms.get(v)) {
         if (!visited[w]) {
            dfs(w, rooms, visited, counter);
         }
      }

   }

   public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      boolean[] visited = new boolean[rooms.size()];
      AtomicInteger counter = new AtomicInteger();
      dfs(0, rooms, visited, counter);

      return counter.get() == rooms.size();
   }


   public static void main(String[] args) {
      System.out.println(new KeysAndRooms().canVisitAllRooms(
          Arrays.asList(
              Arrays.asList(1),
              Arrays.asList(2),
              Arrays.asList(3),
              Arrays.asList()

      )));
   }

}
