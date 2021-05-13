import sort.BinaryInsertionSort;
import sort.CountingSort;
import sort.Testing;


public class Main {
    public static void main(String[] args) {
        Testing testing = new Testing();
        int[] arrRandom = testing.generateRandomIntArray();
        int[] arrSorted = testing.generateSortedIntArray();
        int[] arrReverseSorted = testing.generateReverseSortedIntArray();

        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        CountingSort countingSort = new CountingSort();

        countingSort.sort(arrSorted);
        binaryInsertionSort.sort(arrSorted);


    }
}