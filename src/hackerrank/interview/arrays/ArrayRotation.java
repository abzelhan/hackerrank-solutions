package hackerrank.interview.arrays;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Stream;

public class ArrayRotation {

   public static List<Integer> rotLeft(List<Integer> a, int d) {
      if (d == a.size()) {
         return a;
      }

      int temp;

      for (int i = 0; i < d; i++) {
         temp = a.get(0);
         a.remove(0);
         a.add(temp);
      }

      return a;
   }

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new StringReader("5 4\n"
          + "1 2 3 4 5"));
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);

      int d = Integer.parseInt(firstMultipleInput[1]);

      List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());

      List<Integer> result = rotLeft(a, d);

      bufferedWriter.write(
          result.stream()
              .map(Object::toString)
              .collect(joining(" "))
              + "\n"
      );

      bufferedReader.close();
      bufferedWriter.close();
   }
}

