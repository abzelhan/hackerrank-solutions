package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 * Medium
 * Solved by Max Heap Implementation with priority queue
 * Time complexity O(n) + O(log n) + O(k * log n) ??? Prove this later 
 */
public class TopKFrequentElements {

   class Pair implements Comparable<Pair> {

      private int key;
      private Integer value;

      public Pair(int key, Integer value) {
         this.key = key;
         this.value = value;
      }

      public int getKey() {
         return key;
      }

      public void setKey(int key) {
         this.key = key;
      }

      public Integer getValue() {
         return value;
      }

      public void setValue(Integer value) {
         this.value = value;
      }

      @Override
      public int compareTo(Pair o) {
         return o.value.compareTo(this.value);
      }
   }

   public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> dictionary = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
         dictionary.put(nums[i], dictionary.getOrDefault(nums[i], 0) + 1);
      }

      PriorityQueue<Pair> sortedPairs = new PriorityQueue<>();

      for (Entry<Integer, Integer> entry : dictionary.entrySet()) {
         sortedPairs.add(new Pair(entry.getKey(), entry.getValue()));
      }

      int[] topFrequentElements = new int[k];

      for (int i = 0; i < k; i++) {
         topFrequentElements[i] = sortedPairs.poll().getKey();
      }

      return topFrequentElements;
   }

   public static void main(String[] args) {
      System.out.println(
          Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 2}, 2)));
   }

}
