package algorithms.implementation.medium;

import java.io.File;
import java.io.FileWriter;
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

    static int[] climbingLeaderboardEnhanced(int[] scores, int[] alice) {
        scores = IntStream.of(scores).distinct().toArray();
        int scoreIndex = scores.length - 1;
        int aliceIndex = 0;

        while (scoreIndex >= 0) {
            if (alice[aliceIndex] < scores[scoreIndex]) {
                alice[aliceIndex] = scoreIndex + 2;
                aliceIndex++;
            } else if (alice[aliceIndex] == scores[scoreIndex]) {
                alice[aliceIndex] = scoreIndex + 1;
                aliceIndex++;
            } else if (alice[aliceIndex] > scores[scoreIndex]) {
                //check if the next element is bigger that this
                if (scoreIndex - 1 >= 0 && scores[scoreIndex -1] > alice[aliceIndex]) {
                    alice[aliceIndex] = scoreIndex + 1;
                    aliceIndex++;
                } else if (scoreIndex == 0 && alice[aliceIndex] >= scores[scoreIndex]) {
                    alice[aliceIndex] = 1;
                    aliceIndex++;
                }
            }
            scoreIndex--;
        }

        return alice;
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

            if (alice[i] == 8275) {
                System.out.println("here");
            }
        }

        return alice;
    }

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner("8\n" +
//                "130 100 100 50 40 40 20 10\n" +
//                "5\n" +
//                "5 25 25 50 140");

        Scanner scanner = new Scanner(new File("input07.txt"));
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

        FileWriter fileWriter = new FileWriter("output.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            stringBuilder.append(result[i]);
            System.out.println(result[i]);

            if (i != result.length - 1) {
                stringBuilder.append("\n");
                System.out.println("\n");
            }
        }
        stringBuilder.append("\n");
        fileWriter.append(stringBuilder.toString());
        fileWriter.flush();
        fileWriter.close();
        System.out.println("\n");
        scanner.close();
    }
}
