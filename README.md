# STEP-week10_Assignment

## Week 10 Assignment (Category C Coding Problems)

This repository contains Java solutions for the **STEP Week 10 Coding Assignment** (Category C problems).

### Problems and Solutions

| Problem Number | Original Category C Problem | Title | Solution File |
| :---: | :---: | :--- | :--- |
| **Problem 1** | Problem 4 | Exam Score Band Counter | `Problem1_ExamScoreBandCounter.java` |
| **Problem 2** | Problem 6 | Class Attendance Tracker | `Problem2_ClassAttendanceTracker.java` |
| **Problem 3** | Problem 7 | Second-Best Score | `Problem3_SecondBestScore.java` |
| **Problem 4** | Problem 8 | Duty Roster Rotation | `Problem4_DutyRosterRotation.java` |
| **Problem 5** | Problem 10 | Busiest Bus Row | `Problem5_BusiestBusRow.java` |

---

### Complexity Summaries

1. **Problem 1: Exam Score Band Counter**
   - **Time Complexity:** $O(\log n)$ using binary search (`lower_bound` and `upper_bound`).
   - **Space Complexity:** $O(1)$ auxiliary space.
   - *Linear scan comparison:* A linear scan takes $O(n)$ time. With $n \le 10^6$ and repeated queries, $O(\log n)$ binary search is required. Duplicates at the edge boundaries are handled cleanly by finding the first index with score $\ge \text{low}$ and first index with score $> \text{high}$.

2. **Problem 2: Class Attendance Tracker**
   - **Time Complexity:** $O(n)$ in a single pass.
   - **Space Complexity:** $O(1)$ auxiliary space.
   - *Single pass:* Tracks total present days and updates the maximum unbroken streak as 1s are encountered.

3. **Problem 3: Second-Best Score**
   - **Time Complexity:** $O(n)$ in a single pass without sorting.
   - **Space Complexity:** $O(1)$ auxiliary space.
   - *Sorting comparison:* Sorting takes $O(n \log n)$ time. A single pass maintaining `highest` and `second` distinct values achieves optimal $O(n)$ time and $O(1)$ space.

4. **Problem 4: Duty Roster Rotation**
   - **Time Complexity:** $O(n)$.
   - **Space Complexity:** $O(n)$ for the returned roster array, $O(1)$ auxiliary space.
   - *Large $k$ handling:* Rotating one position at a time takes $O(k \cdot n)$ time. With $k \le 10^9$, that would take $\approx 10^{11}$ operations causing timeout. Using $k \pmod n$ reduces redundant cycles to $O(1)$ and calculates target indices $(i + k) \pmod n$ directly in $O(n)$.

5. **Problem 5: Busiest Bus Row**
   - **Time Complexity:** $O(r \cdot c)$ where $r$ is the number of rows and $c$ is the number of columns.
   - **Space Complexity:** $O(1)$ auxiliary space.
   - *Tie-breaking:* Only strictly greater row sums update the record, preserving the lowest row index when ties occur.
