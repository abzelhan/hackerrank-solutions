package leetcode.easy;

public class LongestCommonPrefix {

   private static class TrieNode {

      private TrieNode[] next = new TrieNode[26];
      private int count;
      private char letter;
   }

   private final TrieNode root = new TrieNode();

   private void insert(String word) {
      TrieNode node = root;

      for (int i = 0; i < word.length(); i++) {
         int index = word.charAt(i) - 'a';

         if (node.next[index] == null) {
            node.next[index] = new TrieNode();
            node.next[index].letter = word.charAt(i);
         }

         node = node.next[index];
         node.count++;

      }
   }

   public String longestCommonPrefix(String[] strs) {
      for (String str : strs) {
         insert(str);
      }

      StringBuilder str = new StringBuilder();
      TrieNode node = root;

      while (true) {
         int maxCount = -1;
         int maxIndex = -1;

         for (int i = 0; i < 26; i++) {
            if (node.next[i] != null && node.next[i].count > maxCount) {
               maxCount = node.next[i].count;
               maxIndex = i;
               node = node.next[i];
            }
         }

         if (maxCount != strs.length || maxIndex == -1) {
            break;
         }

         str.append(node.letter);
      }

      return str.toString();
   }

   public static void main(String[] args) {
      System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"}));
   }

}
