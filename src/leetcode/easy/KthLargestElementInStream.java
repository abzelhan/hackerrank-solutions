package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

   private static class KthLargest {

      private PriorityQueue<Integer> priorityQueue;
      private int k;

      public KthLargest(int k, int[] nums) {
         priorityQueue = new PriorityQueue<>(Comparator.<Integer>naturalOrder());
         for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
         }

         this.k = k;
         while (priorityQueue.size() > k) {
            priorityQueue.poll();
         }
      }

      public int add(int val) {
         priorityQueue.add(val);
         while (priorityQueue.size() > k) {
            priorityQueue.poll();
         }
         return priorityQueue.peek();
      }
   }

   public static void main(String[] args) {
      KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
      System.out.println(kthLargest.add(3));
      System.out.println(kthLargest.add(5));
      System.out.println(kthLargest.add(10));
      System.out.println(kthLargest.add(9));
      System.out.println(kthLargest.add(4));
   }

}
