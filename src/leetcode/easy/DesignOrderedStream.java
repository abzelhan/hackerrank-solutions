package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class DesignOrderedStream {

   private static class Pair {

      String value;
      int id;

      Pair(String value, int id) {
         this.value = value;
         this.id = id;
      }
   }

   private static class OrderedStream {

      private int lastOrderedId;
      private final Pair[] pairs;

      public OrderedStream(int n) {
         lastOrderedId = 1;
         pairs = new Pair[n + 1];
      }

      public List<String> insert(int idKey, String value) {
         List<String> chunk = new LinkedList<>();
         pairs[idKey] = new Pair(value, idKey);

            while (pairs[lastOrderedId] != null) {
               chunk.add(pairs[lastOrderedId].value);
               lastOrderedId++;
            }

         return chunk;
      }
   }

   public static void main(String[] args) {

   }

}
