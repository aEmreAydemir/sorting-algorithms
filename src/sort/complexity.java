package sort;

import java.util.HashMap;
import java.util.Map;

public abstract class complexity{
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
        time_and_count[1] = getNumberOfBasicOp();

        return time_and_count;
    }


    public long execTime(int[] arr) {
        long startTime = System.nanoTime();
        sort(arr);
        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime);

        return durationInMillis;
    }

    protected abstract void sort(int[] arr);
    protected abstract int getNumberOfBasicOp();

}
