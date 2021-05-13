package sort;

import java.util.Map;
// INCLUDE this interface to all sorting algorithms
// includes all mandatory methods
public interface sorting {
    void sort(int[] nums);

    Map<String, long[]> getTimeComplexity();

    Map<String, long[]> getTimeComplexity(int n);

    long[] getTimeAndCount(int[] arr);

    long execTime(int[] arr);

}
