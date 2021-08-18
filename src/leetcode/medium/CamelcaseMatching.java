package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class CamelcaseMatching {

   public static boolean isMatched(char[] query, char[] pattern) {
      int patternPos = 0;

      for (int i = 0; i < query.length; i++) {
         if (patternPos < pattern.length && query[i] == pattern[patternPos]) {
            patternPos++;
         } else if (Character.isUpperCase(query[i])) {
            return false;
         }
      }

      return patternPos == pattern.length;
   }

   public static List<Boolean> camelMatch(String[] queries, String pattern) {
      List<Boolean> result = new LinkedList<>();

      char[] patternChar = pattern.toCharArray();

      for (String query : queries) {
         result.add(isMatched(query.toCharArray(), patternChar));
      }

      return result;
   }

   public static void main(String[] args) {
      camelMatch(new String[]{"uAxaqlzahfialcezsLfj","cAqlzyahaslccezssLfj","AqlezahjarflcezshLfj","AqlzofahaplcejuzsLfj","tAqlzahavslcezsLwzfj","AqlzahalcerrzsLpfonj","AqlzahalceaczdsosLfj","eAqlzbxahalcezelsLfj"},
          "AqlzahalcezsLfj");
   }

}
