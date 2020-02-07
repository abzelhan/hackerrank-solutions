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

public class BetweenTwoSets {

    public static int getTotalX2(List<Integer> a, List<Integer> b) {

        for (Integer b1 : b) {
            for (Integer a1 : a) {
                if (b1 % a1 != 0) return 0;
            }
        }


        Integer max = null;
        for (Integer b1 : b) {
            if (max == null || (max != null && max < b1)) {
                max = b1;
            }
        }

        int counter = 0;

        for (int i = 2; i <= max; i++) {
            int aCount = 0;
            int bCount = 0;

            for (Integer a1 : a) {

                if(a1 == i) {
                    aCount++;
                    continue;
                } else if ((a1 < i) && (i % a1 != 0)
                        ||
                        (a1 > i) && (a1 % i != 0)){
                    aCount = 0;
                    break;
                }

                aCount++;
            }

            for (Integer b1 : b) {
                if ((b1 < i) && (i % b1 != 0)
                        ||
                        (b1 > i) && (b1 % i != 0)) break;
                bCount++;
            }

            if(aCount == a.size() && bCount == b.size()) {
                counter++;
            }
        }

        return counter;
    }


    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int x=1,r=0,j=0,count=0;
        int[] d = new int[101];
        for(x=1;x<101;x++){
            int c=0;
            for(int i=0;i<a.size();i++) {
                if(x%a.get(i)==0&&x>=a.get(i)){
                    c++;
                }
            }
            if(c==a.size()){
                d[j] = x;
                r++;
                j++;
            }
        }
        for(j=0;j<r;j++){
            int c=0;
            for(int i=0;i<b.size();i++){
                if(b.get(i)%d[j]==0){
                    c++;
                }
            }
            if(c==b.size()){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {

        System.out.println(2 % 1);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = getTotalX(arr, brr);

        System.out.println(total);

        bufferedReader.close();
    }
}

