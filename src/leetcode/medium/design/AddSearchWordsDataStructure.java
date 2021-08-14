package leetcode.medium.design;

public class AddSearchWordsDataStructure {

   static class TrieNode {

      public final TrieNode[] next = new TrieNode[26];
      public boolean isWord;
      public char letter;

   }

   static class WordDictionary {

      private final TrieNode root = new TrieNode();

      public WordDictionary() {

      }

      public void addWord(String word) {
         TrieNode node = root;

         for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (node.next[index] == null) {
               node.next[index] = new TrieNode();
               node.next[index].letter = word.charAt(i);
            }

            node = node.next[index];
         }

         node.isWord = true;
      }

      public boolean search(String word) {
         return search(root, word, "", 0);
      }

      public boolean search(TrieNode node, String word, String prefix, int depth) {
         if (node == null) {
            return false;
         }

         if (node.isWord && word.length() == prefix.length() ) {
            if (word.contains(".")) {
              word = word.replaceAll(".", "");
               return prefix.contains(word);
            }
            return word.equals(prefix);
         }

         if (depth == word.length()) {
            return false;
         }

         char letter = word.charAt(depth);

         if (letter == '.') {
            for (int i = 0; i < 26; i++) {
               if (node.next[i] != null) {
                  boolean exist = search(node.next[i], word, prefix + node.next[i].letter,
                      depth + 1);

                  if (exist) {
                     return true;
                  }
               }
            }
         } else {
            int index = letter - 'a';

            if (node.next[index] != null) {
               return search(node.next[index], word, prefix + node.next[index].letter, depth + 1);
            }

         }

         return false;
      }

   }

   public static void main(String[] args) {
      WordDictionary wordDictionary = new WordDictionary();
      wordDictionary.addWord("bad");

      System.out.println(wordDictionary.search("..e"));
   }

}
