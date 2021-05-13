import sort.BinaryInsertionSort;
import sort.CountingSort;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        CountingSort countingSort = new CountingSort();

        int[] sizes = new int[50]; // sample sizes
        for (int i = 1; i <= sizes.length; i++) {
            sizes[i - 1] = (int) Math.pow(i, 3);
        }

        for (int i = 0; i < sizes.length; i++) {
            binaryInsertionSort.getTimeComplexity(sizes[i]);
            binaryInsertionSort.writeToFile();

            countingSort.getTimeComplexity(sizes[i]);
            countingSort.writeToFile();
        }
    }

}