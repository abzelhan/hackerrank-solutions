package leetcode.medium;

public class Trie {

   private static class Node {

      private Node[] next = new Node[26];
      private boolean isWord = false;
   }

   private final Node root;

   /**
    * Initialize your data structure here.
    */
   public Trie() {
      root = new Node();
   }

   /**
    * Inserts a word into the trie.
    */
   public void insert(String word) {
      insert(root, word, 0);
   }

   public Node insert(Node node, String word, int depth) {
      if (node == null) {
         node = new Node();
      }

      if (depth == word.length()) {
         node.isWord = true;
         return node;
      }

      char c = word.charAt(depth);
      int ind = c - 'a';
      node.next[ind] = insert(node.next[ind], word, depth + 1);
      return node;
   }

   /**
    * Returns if the word is in the trie.
    */
   public boolean search(String word) {
      Node cur = root;

      for (int i = 0; i < word.length(); i++) {

         if (cur != null) {
            cur = cur.next[word.charAt(i) - 'a'];
         } else {
            return false;
         }
      }

      return cur != null && cur.isWord;
   }

   /**
    * Returns if there is any word in the trie that starts with the given prefix.
    */
   public boolean startsWith(String prefix) {
      Node cur = root;
      int depth = 0;

      while (cur != null) {
         char c = prefix.charAt(depth);
         cur = cur.next[c - 'a'];
         depth++;

         if (depth == prefix.length() && cur != null) {
            return true;
         }
      }

      return false;
   }

   public static void main(String[] args) {
      Trie trie = new Trie();
      trie.insert("hello");
      System.out.println(trie.search("helloa"));
   }

}
