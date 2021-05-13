import sort.BinaryInsertionSort;
import sort.CountingSort;
import sort.Testing;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Testing testing = new Testing();
        int[] arrRandom = testing.generateRandomIntArray();
        int[] arrSorted = testing.generateSortedIntArray();
        int[] arrReverseSorted = testing.generateReverseSortedIntArray();

        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        CountingSort countingSort = new CountingSort();

        Map<String, long[]> complexity = new HashMap<>();
        complexity = binaryInsertionSort.getTimeComplexity();

        System.out.println(complexity.get("best")[0]+ "/////" + complexity.get("worst")[1]);

    }
}