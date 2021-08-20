package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MagicDictionarySlow {

   class MagicDictionary {

      HashMap<Integer, List<String>> map = new HashMap<>();

      public MagicDictionary() {

      }

      public void buildDict(String[] dictionary) {
         for (String s : dictionary) {
            List<String> words = map.getOrDefault(s.length(), new LinkedList<>());

            words.add(s);

            map.put(s.length(), words);
         }

      }

      public boolean search(String searchWord) {
         List<String> words = map.get(searchWord.length());

         if (words != null) {
            for (String word : words) {

               int counter = 0;

               for (int i = 0; i < searchWord.length(); i++) {
                  if (word.charAt(i) != searchWord.charAt(i)) {
                     counter++;
                  }
               }

               if (counter == 1) {
                  return true;
               }
            }
         }


         return false;
      }
   }

   public static void main(String[] args) {

   }

}
