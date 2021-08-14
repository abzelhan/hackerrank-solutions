package leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

   private static class TrieNode {

      private final TrieNode[] next = new TrieNode[26];
      private boolean isWord;
      private int length;

   }

   private static class Trie {

      private final TrieNode root = new TrieNode();

      public void insert(String word) {
         TrieNode node = root;

         for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (node.next[index] == null) {
               node.next[index] = new TrieNode();
               node.next[index].length = i + 1;
            }

            node = node.next[index];
         }

         node.isWord = true;
      }

      public TrieNode find(String prefix) {
         TrieNode node = root;

         for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';

            if (node.next[index] != null) {
               node = node.next[index];

               if (node.isWord) {
                  return node;
               }
            } else {
               return null;
            }

         }

         return node.isWord ? node : null;
      }


   }

   public String replaceWords(List<String> dictionary, String sentence) {
      Trie trie = new Trie();
      for (String word : dictionary) {
         trie.insert(word);
      }
      StringBuilder stringBuilder = new StringBuilder();
      String[] words = sentence.split(" ");

      for (int i = 0; i < words.length; i++) {
         TrieNode node = trie.find(words[i]);

         if (node != null) {
            stringBuilder.append(words[i], 0, node.length);
         } else {
            stringBuilder.append(words[i]);
         }

         if (i < words.length - 1) {
            stringBuilder.append(" ");
         }
      }


      return stringBuilder.toString();
   }

   public static void main(String[] args) {
      System.out.println(new ReplaceWords().replaceWords(Arrays.asList("catt","cat","bat","rat"), "the cattle was rattled by the battery"));
   }

}
