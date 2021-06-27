package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

   static class Pair implements Comparable<Pair> {

      Character key;
      Integer value;

      public Pair(Character key, Integer value) {
         this.key = key;
         this.value = value;
      }

      @Override
      public int compareTo(Pair that) {
         int result = that.value.compareTo(this.value);

         if (result == 0) {
            result = this.key.compareTo(that.key);
         }

         return result;
      }
   }


   public String frequencySort(String s) {
      StringBuilder builder = new StringBuilder();

      Map<Character, Integer> countedCharacterMap = new HashMap<>();

      for (int i = 0; i < s.length(); i++) {
         char currentChar = s.charAt(i);
         countedCharacterMap.put(currentChar, countedCharacterMap.getOrDefault(currentChar, 0) + 1);
      }

      PriorityQueue<Pair> sortedChars = new PriorityQueue<>();

      for (Entry<Character, Integer> entry : countedCharacterMap.entrySet()) {
         sortedChars.add(new Pair(entry.getKey(), entry.getValue()));
      }

      while (!sortedChars.isEmpty()) {

         Pair poll = sortedChars.poll();
         for (int i = 0; i < poll.value; i++) {
            builder.append(poll.key);
         }
      }

      return builder.toString();
   }

   public static void main(String[] args) {
      System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
   }

}
