package interviews;

import java.util.*;
import java.lang.*;
import java.io.*;


//Solved using prefix sum approach
public class StorageOptimization {

   public static void main (String[] args) throws java.lang.Exception
   {
      String s = "|**|*|*";
      //
      int maxLeftBound[] = new int [s.length()];
      int maxIndex = -1;
      for (int i = 0; i < s.length(); ++i) {
         if (s.charAt(i) == '|')
            maxIndex = i;
         maxLeftBound[i] = maxIndex;
      }

      int minRightBound[] = new int [s.length()];
      int minIndex = -1;
      for (int i = s.length() - 1; i >= 0; --i) {
         if (s.charAt(i) == '|')
            minIndex = i;
         minRightBound[i] = minIndex;
      }

      int prefix[] = new int[s.length()];
      int cnt = 0;
      for (int i = 0; i < s.length(); ++i) {
         if (s.charAt(i) == '*')
            cnt++;
         prefix[i] = cnt;
      }
      System.out.println(cnt);
      //O(n) + O(q)
      // q => O(1)
      // ||******|||
      // ***||*
      int startIndex = 1, endIndex = 6;
      startIndex--; endIndex--;
      int l = minRightBound[startIndex], r = maxLeftBound[endIndex];
      System.out.println(l + " " + r);
      if (l > endIndex || r < startIndex || r == l) {
         System.out.println(0);
      } else {
         System.out.println(prefix[r] - (l > 0 ? prefix[l - 1] : 0));
      }

      // 3 8
   }

}
