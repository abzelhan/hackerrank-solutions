package algorithms.implementation.medium;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ClimbingTheLeaderboard {

    public static int binarySearchIterativeReversed(int[] arr, int x) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < x) {
                end = mid;
            } else {
                if (arr[mid] <= x) {
                    return mid;
                }
                start = mid + 1;
            }
        }
        return -1;
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        scores = IntStream.of(scores).distinct().toArray();
        int lastPosition = scores.length - 1;
        for (int i = 0; i < alice.length; i++) {
            int boardIndex = binarySearchIterativeReversed(scores, alice[i]);
            if (boardIndex != -1) {
                alice[i] = boardIndex + 1;
            } else {
                //check if score is biggest
                if (alice[i] > scores[0]) {
                    alice[i] = 1;
                }
                //check if her score is lowest
                else if (alice[i] < scores[scores.length - 1]) {
                    alice[i] = scores.length + 1;
                }

                for (int j = lastPosition; j >= 0; j--) {
                    if (j - 1 >= 0 && scores[j - 1] > alice[i])
                        if (scores[j] < alice[i]) {
                            alice[i] = j + 1;
                            lastPosition = j;
                            break;
                        }
                }
            }
        }

        return alice;
    }

//    static int[] climbingLeaderboard(int[] scores, int[] alice) {
//        List<Integer> leaderboard = Arrays.stream(scores).boxed().distinct().collect(Collectors.toList());
//        for (int i = 0; i < alice.length; i++) {
//            if (leaderboard.contains(alice[i])) {
//                alice[i] = leaderboard.indexOf(alice[i]) + 1;
//            } else {
//                //check if score is biggest
//                if (alice[i] > leaderboard.get(0)) {
//                    alice[i] = 1;
//                }
//                //check if her score is lowest
//                else if (alice[i] < leaderboard.get(leaderboard.size() - 1)) {
//                    alice[i] = leaderboard.size() + 1;
//                }
//
//                for (int j = leaderboard.size() - 1; j >= 0; j--) {
//                    if (j - 1 >= 0 && leaderboard.get(j - 1) > alice[i])
//                        if (leaderboard.get(j) < alice[i]) {
//                            alice[i] = j + 1;
//                            break;
//                        }
//                }
//            }
//        }
//
//        return alice;
//    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner("7\n" +
//                "100 100 50 40 40 20 10\n" +
//                "4\n" +
//                "5 25 50 120");

        Scanner scanner = new Scanner(new File("input06.txt"));
        int scoresCount = scanner.nextInt();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

            if (i != result.length - 1) {
                System.out.println("\n");
            }
        }

        System.out.println("\n");
        scanner.close();
    }
}
