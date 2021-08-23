package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreak {

   public boolean wordBreak(String word, List<String> wordDict) {
      Set<String> set = new HashSet<>(wordDict);
      boolean[] dp = new boolean[word.length() + 1];
      dp[0] = true;
      int maxLen = 0;

      for (String wd : wordDict) {
         maxLen = Math.max(wd.length(), maxLen);
      }

      for (int i = 0; i <= word.length(); i++) {
         for (int j = i - 1; j >=0 ; j--) {
            if (i - j > maxLen || !dp[j]) {
               continue;
            }

            if (set.contains(word.substring(j, i))) {
               dp[i] = true;
               break;
            }
         }
      }

      return dp[word.length()];
   }


   /*
    s = "applepenapple", wordDict = ["apple","pen"]
    */
   public static void main(String[] args) {
      System.out.println(new WordBreak().wordBreak(
          "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
          Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
              "aaaaaaaaa", "aaaaaaaaaa")));
   }

}
