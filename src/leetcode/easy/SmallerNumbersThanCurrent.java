package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SmallerNumbersThanCurrent {

   public int[] smallerNumbersThanCurrent(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      int[] res = new int[nums.length];

      for (int i = 0; i < nums.length; i++) {
         if (map.containsKey(nums[i])) {
            res[i] = map.get(nums[i]);
         } else {
            int counter = 0;
            for (int j = 0; j < nums.length; j++) {
               if (i != j && nums[i] > nums[j]) {
                  counter++;
               }
            }

            map.put(nums[i], counter);
            res[i] = counter;
         }
      }

      return res;
   }

   public static void main(String[] args) {

   }

}
