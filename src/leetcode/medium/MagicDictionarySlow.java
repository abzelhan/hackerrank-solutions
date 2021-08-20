package leetcode.medium;

import java.util.LinkedList;

public class MagicDictionarySlow {

   class MagicDictionary {

      LinkedList<String> list = new LinkedList<>();

      /**
       * Initialize your data structure here.
       */
      public MagicDictionary() {

      }

      public void buildDict(String[] dictionary) {
         for (String s : dictionary) {
            list.add(s);
         }

      }

      public boolean search(String searchWord) {
         for (String word : list) {

            if (word.length() == searchWord.length()) {
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
