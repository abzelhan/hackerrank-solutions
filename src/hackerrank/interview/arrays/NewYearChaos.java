package hackerrank.interview.arrays;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewYearChaos {

   public static void minimumBribes(List<Integer> q) {
      List<Integer> bribes = new ArrayList<>();
      int counter = 0;
      for (int i = 0; i < q.size() - 1; i++) {
//         if (!(q.get(i) < q.get(i + 1))) {
         if (q.get(i) != (i+1)) {

            int sum = q.get(i) - (i + 1);
            if (sum < 3) {
               counter += sum;
            } else {
               System.out.println("Too Chaotic");
               return;
            }
         }

      }
      System.out.println(counter);

   }

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new StringReader("1\n"
          + "8\n"
          + "1 2 3 4 5 7 8 6"));

      int t = Integer.parseInt(bufferedReader.readLine().trim());

      IntStream.range(0, t).forEach(tItr -> {
         try {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> q = Stream
                .of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

            minimumBribes(q);
         } catch (IOException ex) {
            throw new RuntimeException(ex);
         }
      });

      bufferedReader.close();
   }

}
