package hackerrank.interview.arrays;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

   /*
    * Complete the 'hourglassSum' function below.
    *
    * The function is expected to return an INTEGER.
    * The function accepts 2D_INTEGER_ARRAY arr as parameter.
    */

   public static int hourglassSum(List<List<Integer>> arr) {
      List<Integer> sums = new ArrayList<>();
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            int sum = (arr.get(i).get(j)) + (arr.get(i).get(j + 1)) + (arr.get(i).get(j + 2))
                + (arr.get(i + 1).get(j + 1))
                + (arr.get(i + 2).get(j)) + (arr.get(i + 2).get(j + 1)) + (arr.get(i + 2)
                .get(j + 2));
            sums.add(sum);
         }
      }

      return Collections.max(sums);
  /*    List sum = new ArrayList();
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            sum.add(
                arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[
                    i + 2][j + 1] + arr[i + 2][j + 2]);
         }
      }
      System.out.println(Collections.max(sum));*/
   }


}

public class Array2D {

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new StringReader(
          "1 1 1 0 0 0\n"
              + "0 1 0 0 0 0\n"
              + "1 1 1 0 0 0\n"
              + "0 0 2 4 4 0\n"
              + "0 0 0 2 0 0\n"
              + "0 0 1 2 4 0"));
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

      List<List<Integer>> arr = new ArrayList<>();

      IntStream.range(0, 6).forEach(i -> {
         try {
            arr.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList())
            );
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }
      });

      int result = Result.hourglassSum(arr);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
   }
}

