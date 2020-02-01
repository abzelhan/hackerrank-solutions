package algorithms.implementation.easy;

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

/*
    Url: https://www.hackerrank.com/challenges/grading/problem
 */
class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        for (int i = 0; i < grades.size(); i++) {
            Integer grade = grades.get(i);
            if (grade > 37 && grade % 5 > 2) {
                grades.set(i, grade + 5 - grade % 5);
            }
        }
        return grades;
    }

}

public class GradingStudents {

    /*
        Input:
        4
        73
        67
        38
        33
        Output:
        75
        67
        40
        33
     */
    public static void main(String[] args) throws IOException {



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedReader.close();
        System.out.println(result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n");
    }
}

