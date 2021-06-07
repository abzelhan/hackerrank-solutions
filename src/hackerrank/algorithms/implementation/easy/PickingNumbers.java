package hackerrank.algorithms.implementation.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
    URL: https://www.hackerrank.com/challenges/picking-numbers/problem
 */
public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        a.sort(Integer::compareTo);
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : a) {
            if (map.containsKey(num)) {
                map.put(num, Integer.valueOf(map.get(num).intValue() + 1));
            } else {
                map.put(num, 1);
            }
        }

        int max = 0;

        List<Integer> nums = map.entrySet().stream().map(Map.Entry::getKey).collect(toList());
        nums.sort(Integer::compareTo);

        for (int i = 0; i < nums.size(); i++) {
            if ((i < nums.size() - 1) && Math.abs(nums.get(i) - nums.get(i + 1)) <= 1) {
                int length = map.get(nums.get(i)) + map.get(nums.get(i + 1));
                if (length > max) {
                    max = length;
                }
            } else if (map.get(nums.get(i)) > max) {
                max = map.get(nums.get(i));
            }
        }

        return max;
    }

    /*
        Input:
        6
        1 2 2 3 1 2
        Output:
        5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = pickingNumbers(a);

        System.out.println(result);
        bufferedReader.close();
    }
}
