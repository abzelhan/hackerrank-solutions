package leetcode.easy;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 *
 * Time Complexity O(n ^ 2)
 */
public class NumberOfGoodPairs {

   public static int numIdenticalPairs(int[] nums) {
      int counter = 0;
      for (int i = 0; i < nums.length - 1; i++) {
         for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
               counter++;
            }
         }

      }
      return counter;
   }

   public static void main(String[] args) {
      System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
   }

}
