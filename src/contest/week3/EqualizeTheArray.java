package contest.week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EqualizeTheArray {


   public static int equalizeArray(List<Integer> arr) {
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < arr.size(); i++) {
         map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
      }

      int maxCount = 0;

      for (Entry<Integer, Integer> entry : map.entrySet()) {
         if (entry.getValue() > maxCount) {
            maxCount = entry.getValue();
         }
      }

      return arr.size() - maxCount;
   }

   public static void main(String[] args) {
      System.out.println(equalizeArray(Arrays.asList(3, 3, 2, 1, 3)));
   }

}
