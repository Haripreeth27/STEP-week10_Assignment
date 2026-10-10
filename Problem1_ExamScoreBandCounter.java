/**
 * Category C · Coding Assignment
 * Problem 4 / Week 10 Problem 1: Exam Score Band Counter
 *
 * Task:
 * A university stores the marks of all students in an exam as an array sorted in ascending order;
 * marks can repeat. Faculty members frequently ask how many students scored within a band [low, high],
 * inclusive of both ends.
 * Implement a function countInBand(scores, low, high) that returns the number of scores s such that
 * low <= s <= high. The array is large and queried very often, so your solution must not scan the scores
 * one by one.
 *
 * Constraints:
 * - 1 <= length of scores <= 10^6
 * - scores is sorted in ascending order
 * - 0 <= low <= high <= 100
 *
 * Complexity:
 * - Time Complexity: O(log n) using binary search (compared to O(n) for a linear scan).
 * - Space Complexity: O(1) auxiliary space.
 * - Duplicate Handling: Duplicates at the band boundaries are handled using lower bound
 *   (first index with score >= low) and upper bound (first index with score > high).
 */
public class Problem1_ExamScoreBandCounter {

    /**
     * Binary search to find the first index where scores[i] >= target (lower bound).
     * If all elements are smaller than target, returns scores.length.
     */
    public static int findFirstGreaterOrEqual(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Binary search to find the first index where scores[i] > target (upper bound).
     * If all elements are <= target, returns scores.length.
     */
    public static int findFirstStrictlyGreater(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Returns the number of scores in the range [low, high] inclusive.
     */
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int lowerBoundIndex = findFirstGreaterOrEqual(scores, low);
        int upperBoundIndex = findFirstStrictlyGreater(scores, high);

        return upperBoundIndex - lowerBoundIndex;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        // Sample 1: low = 42, high = 58 -> Expected Output: 6
        int result1 = countInBand(scores, 42, 58);
        System.out.println("Sample 1 Output: " + result1);

        // Sample 2: low = 90, high = 100 -> Expected Output: 0
        int result2 = countInBand(scores, 90, 100);
        System.out.println("Sample 2 Output: " + result2);
    }
}
