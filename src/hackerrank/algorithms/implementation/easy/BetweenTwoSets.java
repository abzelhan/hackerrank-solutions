package hackerrank.algorithms.implementation.easy;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
    URL: https://www.hackerrank.com/challenges/between-two-sets/problem
 */
public class BetweenTwoSets {

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

    /*
        Input:
        2 3
        2 4
        16 32 96
        Output:
        3
     */
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

