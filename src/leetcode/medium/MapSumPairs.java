package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

   private static class Node {

      private Node[] next = new Node[26];
      private int val;

   }

   private static class MapSum {

      private final Node root;
      private final Map<String, Integer> map;

      /**
       * Initialize your data structure here.
       */
      public MapSum() {
         root = new Node();
         map = new HashMap<>();
      }

      public void insert(String key, int val) {
         int diff = val - map.getOrDefault(key, 0);

         map.put(key, val);

         Node cur = root;

         for (int i = 0; i < key.length(); i++) {

            int index = key.charAt(i) - 'a';

            if (cur.next[index] == null) {
               cur.next[index] = new Node();
            }

            cur = cur.next[index];
            cur.val += diff;
         }
      }


      public int sum(String prefix) {
         Node cur = root;

         for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';

            if (cur.next[index] == null) {
               return 0;
            }

            cur = cur.next[index];
         }

         return cur.val;
      }
   }

   public static void main(String[] args) {
      MapSum mapSum = new MapSum();
      mapSum.insert("abc", 3);
      mapSum.insert("ab", 3);
      mapSum.insert("ab", 1);
      System.out.println(mapSum.sum("abc"));
   }

}
