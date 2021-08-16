package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class LexicographicalNumbers {

   private static class TrieNode {

      private final TrieNode[] next = new TrieNode[10];
      private boolean isWord;
      private int val;
   }

   private static class Trie {

      private final TrieNode root = new TrieNode();

      public void insert(String word) {
         TrieNode node = root;

         for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - '0';

            if (node.next[index] == null) {
               node.next[index] = new TrieNode();
            }

            node = node.next[index];
         }

         node.isWord = true;
         node.val = Integer.parseInt(word);
      }

      public List<Integer> collectAll() {
         LinkedList<Integer> result = new LinkedList<>();
         dfs(root, result);
         return result;
      }

      public void dfs(TrieNode node, List<Integer> result) {
         if (node != null && node.isWord) {
            result.add(node.val);
         }

         for (int i = 0; i < 10; i++) {
            if (node.next[i] != null) {
               dfs(node.next[i], result);
            }
         }
      }

   }

   public List<Integer> lexicalOrder(int n) {
      Trie trie = new Trie();

      for (int i = 1; i <= n; i++) {
         trie.insert(String.valueOf(i));
      }

      return trie.collectAll();
   }

   public static void main(String[] args) {

   }

}
