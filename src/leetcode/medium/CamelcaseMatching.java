package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class CamelcaseMatching {

   private static class TrieNode {

      TrieNode[] next = new TrieNode[26];
      boolean isUpperCase;
      boolean isWord;
      char letter;
   }

   private static class Trie {

      private final TrieNode root = new TrieNode();

      void insert(String word) {
         TrieNode node = root;

         for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = Character.toLowerCase(letter) - 'a';

            if (node.next[index] == null) {
               node.next[index] = new TrieNode();
               node.next[index].isUpperCase = Character.isUpperCase(letter);
               node.next[index].letter = Character.toLowerCase(letter);
            }

            node = node.next[index];
         }

         node.isWord = true;
      }

   }

   private static List<String> getTokens(StringBuilder tokenBuilder, int patternTokensSize) {
      List<String> tokens = new LinkedList<>();

      if (Character.isLowerCase(tokenBuilder.charAt(0))) {
         for (int i = 0; i < tokenBuilder.length(); i++) {
            if (Character.isUpperCase(tokenBuilder.charAt(i))) {
               tokenBuilder.replace(0, i, "");
               break;
            }
         }
      }

      while (true) {
         boolean isTokenExist = false;
         for (int i = 1; i < tokenBuilder.length(); i++) {
            if (Character.isUpperCase(tokenBuilder.charAt(i))) {
               String token = tokenBuilder.substring(0, i);
               tokens.add(token);
               tokenBuilder.replace(0, i, "");
               isTokenExist = true;
               break;
            }
         }

         if (patternTokensSize != 0 && tokens.size() > patternTokensSize) {
            return null;
         }

         if (!isTokenExist) {
            tokens.add(tokenBuilder.toString());
            break;
         }


      }

      return tokens;
   }

   public static List<Boolean> camelMatch(String[] queries, String pattern) {
      List<String> patternTokens = getTokens(new StringBuilder(pattern), 0);
      List<Boolean> result = new LinkedList<>();

      for (String query : queries) {
         List<String> tokens = getTokens(new StringBuilder(query), patternTokens.size());

         if (tokens == null || tokens.size() != patternTokens.size()) {
            result.add(false);
            continue;
         }

         boolean isValidQuery = true;

         for (int i = 0; i < tokens.size(); i++) {
            int letterPos = 0;

            for (int j = 0; j < tokens.get(i).length(); j++) {
               if (tokens.get(i).charAt(j) == patternTokens.get(i).charAt(letterPos)) {
                  System.out.println(tokens.get(i).charAt(j) + " " + patternTokens.get(i).charAt(letterPos));
                  letterPos++;
               }

               if (letterPos >= patternTokens.get(i).length()) {
                  break;
               }

            }

            if (letterPos != patternTokens.get(i).length()) {
               isValidQuery = false;
               break;
            }
         }

         result.add(isValidQuery);
      }

      return result;
   }

   public static void main(String[] args) {
      camelMatch(new String[]{"uAxaqlzahfialcezsLfj","cAqlzyahaslccezssLfj","AqlezahjarflcezshLfj","AqlzofahaplcejuzsLfj","tAqlzahavslcezsLwzfj","AqlzahalcerrzsLpfonj","AqlzahalceaczdsosLfj","eAqlzbxahalcezelsLfj"},
          "AqlzahalcezsLfj");
   }

}
