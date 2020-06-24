package algorithms.implementation.easy;

import java.util.Arrays;

public class KUniqueCharacters {

    final static int MAX_CHARS = 26;

    static boolean isValid(int[] count, int k) {
        int val = 0;
        for (int i = 0; i < MAX_CHARS; i++) {
            if (count[i] > 0) {
                val++;
            }
        }

        return (k >= val);
    }

    static void kUniques(String s, int k) {
        int u = 0;
        int n = s.length();

        int[] count = new int[MAX_CHARS];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 0) {
                u++;
            }
            count[s.charAt(i) - 'a']++;
        }

        if (u < k) {
            System.out.print("Not enough unique characters");
            return;
        }
        int curr_start = 0, curr_end = 0;

        int max_window_size = 1, max_window_start = 0;

        Arrays.fill(count, 0);

        count[s.charAt(0) - 'a']++;

        for (int i = 1; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            curr_end++;

            while (!isValid(count, k)) {
                count[s.charAt(curr_start) - 'a']--;
                curr_start++;
            }

            if (curr_end - curr_start + 1 > max_window_size) {
                max_window_size = curr_end - curr_start + 1;
                max_window_start = curr_start;
            }
        }

        System.out.println("Max sustring is : "
                + s.substring(max_window_start, max_window_size)
                + " with length " + max_window_size);
    }

    static public void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        kUniques(s, k);
    }
} 
