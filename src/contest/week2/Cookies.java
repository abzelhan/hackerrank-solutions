package contest.week2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Cookies {

  private static class Result {

      /*
       * Complete the 'cookies' function below.
       *
       * The function is expected to return an INTEGER.
       * The function accepts following parameters:
       *  1. INTEGER k
       *  2. INTEGER_ARRAY A
       */

      /**
       * 6 7
       * 1 2 3 9 10 12
       * @param k
       * @param A
       * @return
       */
      public static int cookies(int k, List<Integer> A) {
         if (A.isEmpty()) {
            return -1;
         }

         PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.<Integer>naturalOrder());

         for (int i = 0; i < A.size(); i++) {
            queue.add(A.get(i));
         }

         int count = 0;
         while (!queue.isEmpty()) {

            Integer a1 = queue.poll();
            Integer a2 = queue.poll();


            int s = (a1 * 1) + (a2 * 2);

            queue.add(s);
            count++;

            boolean hasLower = false;
            for (Integer integer : queue) {
               if (integer < k) {
                  hasLower = true;
                  break;
               }
            }

            if (!hasLower) {
               return count;
            }


         }

         return -1;
      }

   }

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);

      int k = Integer.parseInt(firstMultipleInput[1]);

      List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());

      int result = Result.cookies(k, A);

      System.out.println(result);

      bufferedReader.close();
   }
}

