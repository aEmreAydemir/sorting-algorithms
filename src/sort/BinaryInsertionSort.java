package sort;

import java.util.HashMap;
import java.util.Map;

public class BinaryInsertionSort implements sorting{
    private int numberOfTime;

    public void sort(int[] nums) {
        int n = nums.length;
        numberOfTime = 0;
        for (int i = 1; i < n; ++i) {
            int key = nums[i];
            int insertedPosition = findPosition(nums, 0, i - 1, key);

            // shift all elements from insertedPosition to i-1'th element because all of them are bigger
            for (int j = i - 1; j >= insertedPosition; --j) {
                nums[j + 1] = nums[j];
            }
            // insert element at found position
            nums[insertedPosition] = key;
        }
    }

    // binary search to find position for new element
    private int findPosition(int[] nums, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            numberOfTime++; // comparison is selected as the basic operation
            // look at the left side of the array
            if (key < nums[mid]) {
                end = mid - 1;
                // look at the right side of the array
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    // For getting information about best, average and worst time complexity. Return value contains running time of sorting algorithm and count of the basic operation.
    public Map<String, long[]> getTimeComplexity() {
        return getTimeComplexity(-1);
    } // -1 means use default array size in Testing

     public Map<String, long[]> getTimeComplexity(int n) {
        Map<String, long[]> complexity = new HashMap<>();
        Testing testing = new Testing();

        int[] arrSorted;
        int[] arrRandom;
        int[] arrReverseSorted;

        if (n == -1) {// default case
            arrSorted = testing.generateSortedIntArray();
            arrRandom = testing.generateRandomIntArray();
            arrReverseSorted = testing.generateReverseSortedIntArray();
        } else {
            arrSorted = testing.generateSortedIntArray(n);
            arrRandom = testing.generateRandomIntArray(n);
            arrReverseSorted = testing.generateReverseSortedIntArray(n);
        }

        complexity.put("best", getTimeAndCount(arrSorted));
        complexity.put("average", getTimeAndCount(arrRandom));
        complexity.put("worst", getTimeAndCount(arrReverseSorted));

        return complexity;
    }

    // Best case in already sorted array
    // Worst case in reverse order array
     public long[] getTimeAndCount(int[] arr) {
        long[] time_and_count = new long[2];
        time_and_count[0] = execTime(arr);
        time_and_count[1] = numberOfTime;

        return time_and_count;
    }

    public long execTime(int[] arr) {
        long startTime = System.nanoTime();
        sort(arr);
        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime);

        return durationInMillis;
    }
}
