/**
 * Category C · Coding Assignment
 * Problem 7 / Week 10 Problem 3: Second-Best Score
 *
 * Task:
 * A quiz app stores the scores of all players in an array. Prizes go to the top two different
 * scores, so the app needs the second-highest distinct score. If every player has the same score,
 * there is no second-highest score.
 * Implement a function secondHighest(scores) that returns the second-highest distinct score,
 * or -1 if it does not exist.
 *
 * Constraints:
 * - 1 <= length of scores <= 1000
 * - 0 <= scores[i] <= 100
 * - Do not sort the array
 *
 * Complexity:
 * - Time Complexity: O(n) single pass (Sorting would take O(n log n)).
 * - Space Complexity: O(1) auxiliary space.
 */
public class Problem3_SecondBestScore {

    /**
     * Finds the second-highest distinct score without sorting the array.
     *
     * @param scores array of player scores
     * @return second-highest distinct score, or -1 if none exists
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        // Sample 1: scores = [45, 78, 92, 78, 60] -> Expected: 78
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println("Sample 1 Output: " + secondHighest(scores1));

        // Sample 2: scores = [50, 50, 50] -> Expected: -1
        int[] scores2 = {50, 50, 50};
        System.out.println("Sample 2 Output: " + secondHighest(scores2));
    }
}
