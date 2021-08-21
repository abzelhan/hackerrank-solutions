package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class SortingTheSentence {

   public String sortSentence(String s) {
      String[] tokens = s.split(" ");


      Arrays.sort(tokens, Comparator.comparing(s1 -> s1.charAt(s1.length())));

      StringBuilder res = new StringBuilder();

      for (int i = 0; i < tokens.length; i++) {
         res.append(tokens[i].substring(0, tokens[i].length() - 1));

         if (i != tokens.length - 1) {
            res.append(" ");
         }
      }

      return res.toString();
   }

   public static void main(String[] args) {

   }

}
