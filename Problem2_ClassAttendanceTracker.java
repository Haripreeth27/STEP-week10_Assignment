/**
 * Category C · Coding Assignment
 * Problem 6 / Week 10 Problem 2: Class Attendance Tracker
 *
 * Task:
 * A teacher records attendance for one student as an array of 1s (present) and 0s (absent),
 * one value per day. The teacher wants to know how many days the student was present and
 * the longest run of days the student attended without a break.
 * Implement a function attendanceSummary(days) that returns the number of present days and
 * the length of the longest unbroken run of present days.
 *
 * Constraints:
 * - 1 <= length of days <= 100
 * - Each value is 0 or 1
 *
 * Complexity:
 * - Time Complexity: O(n) in a single pass over the array.
 * - Space Complexity: O(1) auxiliary space.
 */
public class Problem2_ClassAttendanceTracker {

    /**
     * Computes the total present days and the longest consecutive attendance streak.
     *
     * @param days array of attendance records (1 = present, 0 = absent)
     * @return int array containing [presentCount, longestStreak]
     */
    public static int[] attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new int[]{0, 0};
        }

        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{presentCount, longestStreak};
    }

    /**
     * Helper method to format the output as specified in the assignment.
     */
    public static String formatSummary(int[] summary) {
        return "Present: " + summary[0] + ", Longest streak: " + summary[1];
    }

    public static void main(String[] args) {
        // Sample 1: days = [1, 1, 0, 1, 1, 1, 0, 1] -> Expected: Present: 6, Longest streak: 3
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] result1 = attendanceSummary(days1);
        System.out.println(formatSummary(result1));

        // Sample 2: days = [0, 0, 0] -> Expected: Present: 0, Longest streak: 0
        int[] days2 = {0, 0, 0};
        int[] result2 = attendanceSummary(days2);
        System.out.println(formatSummary(result2));
    }
}
