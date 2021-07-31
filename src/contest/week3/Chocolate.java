package contest.week3;

import java.util.Arrays;
import java.util.List;

public class Chocolate {

   public static int birthday(List<Integer> s, int d, int m) {
      int counter = 0;

      for(int i = 0; i <= s.size() - m; i++) {

         int sum = 0;
         for(int j = i; j < i + m; j++) {
            sum+=s.get(j);
         }

         if(sum == d) {
            counter++;
         }

      }

      return counter;

   }

   public static void main(String[] args) {
      System.out.println(birthday(Arrays.asList(4), 4, 1));
   }

}
