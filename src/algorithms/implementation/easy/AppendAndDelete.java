package algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * URL:
 * https://www.hackerrank.com/challenges/append-and-delete/problem
 * <p>
 * Input:
 * hackerhappy
 * hackerrank
 * 9
 * <p>
 * Output:
 * Yes
 */
public class AppendAndDelete {

    static String appendAndDelete(String s, String t, int k) {
        String yes = "Yes";
        String no = "No";

        if (s.equals(t)) return yes;
        else if (t.isEmpty()) return k - s.length() >= 0 ? yes : no;
        else if (s.isEmpty()) return k - t.length() >= 0 ? yes : no;

        int index = -1;
        for (int i = 0; i < Math.min(t.length(), s.length()); i++) {
            if (t.charAt(i) != s.charAt(i)) {
                index = i;
                break;
            }
        }

        if (t.length() > s.length()) {
            //check for same chars
            Set<Character> sLetters = s.chars().mapToObj(i -> (char) i).distinct().collect(Collectors.toSet());
            Set<Character> tLetters = t.chars().mapToObj(i -> (char) i).distinct().collect(Collectors.toSet());

            if (sLetters.size() == 1 && tLetters.size() == 1 && sLetters.containsAll(tLetters))
                return k - (t.length() - s.length()) >= 0 ? yes : no;

            return k - (s.length() + t.length()) >= 0 ? yes : no;
        } else if (index != -1) return k - (s.substring(index).length() + t.substring(index).length()) >= 0 ? yes : no;
        else if (s.length() > t.length() && index == -1) return k - s.substring(t.length()).length() >= 0 ? yes : no;
        if (index == -1) return k - t.substring(s.length()).length() >= 0 ? yes : no;

        return yes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        System.out.println(result);

        scanner.close();
    }

}
