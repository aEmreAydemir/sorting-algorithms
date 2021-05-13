import sort.BinaryInsertionSort;
import sort.CountingSort;
import sort.Testing;

public class Main {
    public static void main(String[] args) {
        Testing testing = new Testing();
        int[] list = testing.generateSortedIntArray();

        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort(list);
        CountingSort countingSort = new CountingSort();

    }
}