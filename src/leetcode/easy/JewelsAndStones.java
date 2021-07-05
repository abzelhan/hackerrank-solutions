package leetcode.easy;

import java.util.*;

public class JewelsAndStones {

   public static int numJewelsInStones(String jewels, String stones) {
      Map<Character, Integer> dictionary = new HashMap<>();

      for(int i =0; i< stones.length(); i++) {
         dictionary.put(stones.charAt(i), dictionary.getOrDefault(stones.charAt(i), 0) + 1);
      }

      int totalSum = 0;

      for (int i = 0; i < jewels.length(); i++) {
        totalSum+= dictionary.getOrDefault(jewels.charAt(i), 0);
      }

      return totalSum;
   }

   public static void main(String[] args) {
      System.out.println(numJewelsInStones("z", "ZZ"));
   }

}
