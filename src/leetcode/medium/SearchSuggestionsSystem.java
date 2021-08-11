package leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SearchSuggestionsSystem {

   private static class Node {

      private Node[] next = new Node[26];
      private boolean isWord;
      private char letter;

   }

   private static class Trie {

      private final Node root = new Node();

      public void insert(String word) {
         Node node = root;

         for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (node.next[index] == null) {
               node.next[index] = new Node();
               node.next[index].letter = word.charAt(i);
            }

            node = node.next[index];

         }

         node.isWord = true;
      }

      public Node find(String prefix) {
         Node node = root;

         for (int i = 0; i < prefix.length(); i++) {

            int index = prefix.charAt(i) - 'a';

            if (node.next[index] == null) {
               return null;
            }

            node = node.next[index];
         }

         return node;
      }

      public List<String> findAllWordsByPrefix(String prefix) {
         Node node = find(prefix);

         if (node == null) {
            return new LinkedList<>();
         }

         Queue<String> words = new PriorityQueue<>();

         findAllWordsByPrefix(node, prefix, words);

         return new LinkedList<>(words);
      }

      public void findAllWordsByPrefix(Node node, String prefix, Queue<String> words) {
         if (words.size() == 3) {
            return;
         }

         if (node != null && node.isWord) {
            words.add(prefix);
         }

         for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
               findAllWordsByPrefix(node.next[i],
                   prefix + node.next[i].letter, words);
            }
         }
      }

   }


   public List<List<String>> suggestedProducts(String[] products, String searchWord) {
      Trie trie = new Trie();

      for (String product : products) {
         trie.insert(product);
      }

      List<List<String>> result = new LinkedList<>();

      for (int i = 1; i <= searchWord.length(); i++) {
         System.out.println("here");
         result.add(trie.findAllWordsByPrefix(searchWord.substring(0, i)));
      }

      return result;
   }

   public static void main(String[] args) {
      List<List<String>> mouse = new SearchSuggestionsSystem()
          .suggestedProducts(new String[]{"mouse", "mobile", "moneypot", "monitor", "mousepad"},
              "mouse");
      System.out.println();
   }

}
