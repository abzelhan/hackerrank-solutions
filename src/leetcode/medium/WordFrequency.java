package leetcode.medium;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WordFrequency {

   static class Pair {

      String key;
      Integer value;

      public Pair(String key, Integer value) {
         this.key = key;
         this.value = value;
      }
   }

   public static void main(String[] args) throws Exception {
      StringBuilder word = new StringBuilder();

      Scanner scanner = new Scanner("the day is sunny the the\n"
          + "the sunny is is");

      while (scanner.hasNextLine()) {
         word.append(scanner.nextLine()).append(" ");
      }
      Map<String, Integer> dictionary = new HashMap<>();

      String[] words = word.toString().split(" ");

      for (int i = 0; i < words.length; i++) {
         dictionary.put(words[i], dictionary.getOrDefault(words[i], 0) + 1);
      }

      PriorityQueue<Pair> frequentWordsQueue = new PriorityQueue<>(
          (p1, p2) -> p2.value.compareTo(p1.value));

      for (Entry<String, Integer> entry : dictionary.entrySet()) {
         frequentWordsQueue.add(new Pair(entry.getKey(), entry.getValue()));
      }

      PrintWriter writer = new PrintWriter(System.out);

      while (!frequentWordsQueue.isEmpty()) {
         Pair wordWithCounter = frequentWordsQueue.poll();
         writer.println(wordWithCounter.key + " " + wordWithCounter.value);
      }

      writer.flush();
      writer.close();
   }

}
