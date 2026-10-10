import java.util.Arrays;

/**
 * Category C · Coding Assignment
 * Problem 8 / Week 10 Problem 4: Duty Roster Rotation
 *
 * Task:
 * A hostel rotates its cleaning duty roster every week by moving each name k places to the right;
 * names that go past the end wrap around to the front.
 * Implement a function rotateRoster(names, k) that returns the roster after rotating it to the right
 * by k places. k may be larger than the number of names.
 *
 * Constraints:
 * - 1 <= length of names <= 100
 * - 0 <= k <= 10^9
 *
 * Complexity:
 * - Time Complexity: O(n) where n is the number of names.
 *   Explanation: Rotating one place at a time, k times, requires O(k * n) operations. When k is as
 *   large as 10^9, this would take ~10^11 operations, resulting in unacceptable execution delay or TLE.
 *   By computing k % n, we eliminate redundant full revolutions in O(1) time and place each name directly
 *   into its final position in a single pass of O(n).
 * - Space Complexity: O(n) for the output rotated roster array, with O(1) extra auxiliary space.
 */
public class Problem4_DutyRosterRotation {

    /**
     * Rotates the names array k places to the right.
     *
     * @param names array of student names
     * @param k number of positions to rotate right
     * @return rotated array of names
     */
    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length <= 1) {
            return names;
        }

        int n = names.length;
        int effectiveK = k % n;
        if (effectiveK < 0) {
            effectiveK += n;
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + effectiveK) % n] = names[i];
        }

        return rotated;
    }

    /**
     * Overloaded method to support long k if needed for large rotation values.
     */
    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length <= 1) {
            return names;
        }

        int n = names.length;
        int effectiveK = (int) (k % n);
        if (effectiveK < 0) {
            effectiveK += n;
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + effectiveK) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        // Sample 1: names = [A, B, C, D, E], k = 2 -> Expected: [D, E, A, B, C]
        String[] names1 = {"A", "B", "C", "D", "E"};
        String[] result1 = rotateRoster(names1, 2);
        System.out.println("Sample 1 Output: " + Arrays.toString(result1));

        // Sample 2: names = [A, B, C, D, E], k = 7 -> Expected: [D, E, A, B, C]
        String[] names2 = {"A", "B", "C", "D", "E"};
        String[] result2 = rotateRoster(names2, 7);
        System.out.println("Sample 2 Output: " + Arrays.toString(result2));
    }
}
