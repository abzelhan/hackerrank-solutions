package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {

   private static class TrieNode {

      private TrieNode next[] = new TrieNode[27];
      private boolean isWord;
      private boolean isDelimiter;
      private char letter;

   }

   private static class Trie {

      private final TrieNode root = new TrieNode();

      public void insert(String word) {
         TrieNode node = root;

         boolean isSubfolder = false;

         for (int i = 0; i < word.length(); i++) {
           if(isSubfolder && word.charAt(i) == '/') {
              return;
           }


            int index = word.charAt(i) == '/' ? 26 : word.charAt(i) - 'a';

            if (node.next[index] == null) {
               node.next[index] = new TrieNode();
               node.next[index].isDelimiter = index == 26;
               node.next[index].letter = index == 26 ? '/' : word.charAt(i);
            }

            node = node.next[index];
            isSubfolder = node.isWord;
         }

         node.isWord = true;
      }

      public List<String> collectAllWords(List<String> words) {
         collectAllWords("", root, words);
         return words;
      }

      public void collectAllWords(String prefix, TrieNode node, List<String> words) {
         if (node.isWord) {
            words.add(prefix);

         }

         for (int i = 0; i < 27; i++) {
            if (node.next[i] != null) {
               collectAllWords(prefix + node.next[i].letter, node.next[i], words);
            }
         }
      }

   }

   public List<String> removeSubfolders(String[] folder) {
      Trie trie = new Trie();
      Arrays.sort(folder);
      for (String path : folder) {
         trie.insert(path);
      }

      return trie.collectAllWords(new LinkedList<>());
   }

   public static void main(String[] args) {
      List<String> words = new RemoveSubFoldersFromTheFilesystem()
          .removeSubfolders(new String[]{"/ah/al/am","/ah/al"});

      for (String word : words) {
         System.out.println(word);
      }

   }

}
