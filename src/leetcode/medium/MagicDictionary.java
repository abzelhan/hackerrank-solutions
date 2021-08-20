package leetcode.medium;

public class MagicDictionary {

   private static class TrieNode {

      public final TrieNode[] next = new TrieNode[26];
      public boolean isWord;
      public char letter;
      public boolean alreadyHasLetter;

   }

   private final TrieNode root = new TrieNode();

   private void insert(String word) {
      TrieNode node = root;

      for (int i = 0; i < word.length(); i++) {
         int index = word.charAt(i) - 'a';

         if (node != root) {
            for (int j = 0; j < 26; j++) {
               if (j != index && node.next[j] != null) {
                  node.alreadyHasLetter = true;
                  break;
               }
            }
         }

         if (node.next[index] == null) {
            node.next[index] = new TrieNode();
            node.next[index].letter = word.charAt(i);
         }

         node = node.next[index];
      }

      node.isWord = true;
   }

   public MagicDictionary() {

   }

   public void buildDict(String[] dictionary) {
      for (String word : dictionary) {
         insert(word);
      }

   }

   private boolean find(TrieNode node, String word, int depth, boolean alreadyHasUnknownLetter) {
      if (node == null) {
         return false;
      }

      if (node.isWord) {

         if (word.length() == 1) {
            return !word.equals(node.letter);
         }

         return depth == word.length() && alreadyHasUnknownLetter;
      }

      if (depth >= word.length()) {
         return false;
      }

      int index = word.charAt(depth) - 'a';

      if (node.next[index] == null || node.alreadyHasLetter) {
         if (alreadyHasUnknownLetter && !node.alreadyHasLetter) {
            return false;
         }

         if (node != root) {
            alreadyHasUnknownLetter = true;
         }

         for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
               boolean isExist = find(node.next[i], word, depth + 1, alreadyHasUnknownLetter);

               if (isExist) {
                  return true;
               }
            }
         }

      } else {
         return find(node.next[index], word, depth + 1, alreadyHasUnknownLetter);
      }

      return false;
   }

   public boolean search(String searchWord) {
      return find(root, searchWord, 0, false);
   }

   /*
   ["MagicDictionary", "buildDict", "search", "search", "search", "search", "search", "search"]
[[], [["hello","hallo","leetcode","judge", "judgg"]], ["hello"], ["hallo"], ["hell"], ["leetcodd"], ["judge"], ["judgg"]]
    */

   public static void main(String[] args) {
      MagicDictionary magicDictionary = new MagicDictionary();
//      magicDictionary.buildDict(new String[]{"hello", "hallo"});
      magicDictionary.buildDict(new String[]{"a","b"});

      String[] search = { "a", "b"};
//      String[] search = {"hhllo"};

      for (String s : search) {
         System.out.println(magicDictionary.search(s));
      }


   }

}
