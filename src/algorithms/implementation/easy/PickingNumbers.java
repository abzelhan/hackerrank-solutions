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

public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        ArrayList<Integer> nums = new ArrayList<>();
        a.sort(Integer::compareTo);
        for (int i = 0; i < a.size(); i++) {
            Integer num = a.get(i);
            boolean canPick = false;
            for (int j = 0; j < a.size(); j++) {

                if(i != j)
                if (Math.abs(num - a.get(j)) <= 1) {
                    canPick = true;
                    break;
                }
            }

            if(canPick) {
                if (nums.size() == 0) nums.add(num);
                else {
                    for (Integer validNum : nums) {
                        if (!(Math.abs(validNum - num) <= 1)) {
                            canPick = false;
                            break;
                        }
                    }
                    if (canPick) {
                        nums.add(num);
                    }
                }
            }

        }

        return nums.size();
    }

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
