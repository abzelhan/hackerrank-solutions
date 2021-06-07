package hackerrank.algorithms.implementation.easy;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
    URL: https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int counter = 0;

        for (int i = 0; i < s.size(); i++) {

            int sum = 0;
            if (i + m <= s.size()) {
                for (int j = i; j < i + m ; j++) {
                    sum += s.get(j);
                }
            }
            if (sum == d) {
                counter++;
            }
        }

        return counter;
    }

    /*
        Input:
        6
        1 1 1 1 1 1
        3 2
        Output:
        0
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);
        System.out.println(result);

        bufferedReader.close();
    }
}
