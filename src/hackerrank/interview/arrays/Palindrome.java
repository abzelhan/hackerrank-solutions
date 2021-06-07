package hackerrank.interview.arrays;

public class Palindrome {

   public static boolean isPalindrome(String s) {
      if (s.length() == 2 && (s.charAt(0) != s.charAt(1))) {
         return true;
      }

      String word = new String();
      for (int i = 0; i < s.length(); i++) {
         if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
            word += s.charAt(i);
         }
      }

      word = word.toLowerCase();

      if (word.length() == 1) {
         return false;
      }

      for (int i = 0; i < word.length() / 2; i++) {
         if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
   }

}
