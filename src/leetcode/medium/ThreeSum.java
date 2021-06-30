package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

   public static List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> result = new HashSet<>();
      Arrays.sort(nums);

      Map<Integer, Integer> dictionary = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
         dictionary.put(nums[i], i);
      }

      for (int i = 0; i < nums.length; i++) {
         int num1 = nums[i];
         for (int j = i + 1; j < nums.length; j++) {
            int num2 = nums[j];
            int num3 = 0 - num1 - num2;

            if (dictionary.containsKey(num3) && dictionary.get(num3) > j) {
               List<Integer> sumElements = new ArrayList<>();
               sumElements.add(num1);
               sumElements.add(num2);
               sumElements.add(num3);
               result.add(sumElements);
            }
         }
      }

      return new ArrayList<>(result);
   }

   public static void main(String[] args) {
      List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
      System.out.println();
   }

}
