package hackerrank.algorithms.implementation.medium;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class NonDivisibleSubset {

   public static int nonDivisibleSubset(int k, List<Integer> s) {
      if (k == 0 || k == 1) {
         return 1;
      }
      List<Integer> reminders = new ArrayList<>();
      for (int i = 0; i <= 10; i++) {
         reminders.add(0);
      }
      for (int i = 0; i < s.size(); i++) {
         Integer integer = reminders.get(s.get(i) % k);
         reminders.set(s.get(i) % k, integer + 1);
      }

      int zeroRemainder = reminders.get(0);
      int maxNumberOfDivisibleSet = zeroRemainder > 0 ? 1 : 0;

      for (int i = 1; i <= (k / 2); i++) {
         if (i != k - i) {
            maxNumberOfDivisibleSet += Math.max(reminders.get(i), reminders.get(k - i));
         } else {
            maxNumberOfDivisibleSet++;
         }
      }

      return maxNumberOfDivisibleSet;
   }

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new StringReader("15 7\n"
          + "278 576 496 727 410 124 338 149 209 702 282 718 771 575 436"));
      BufferedWriter bufferedWriter = new BufferedWriter(
          new OutputStreamWriter(System.out));

      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);

      int k = Integer.parseInt(firstMultipleInput[1]);

      List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());

      int result = nonDivisibleSubset(k, s);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
   }

}
