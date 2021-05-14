import sort.BinaryInsertionSort;
import sort.CountingSort;
import sort.HeapSort;
import sort.MergeSort;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        CountingSort countingSort = new CountingSort();
        //HeapSort heapSort= new HeapSort();
        //MergeSort mergeSort=new MergeSort();
        boolean firstRun = true;

        int[] sizes = new int[120]; // sample sizes
        for (int i = 1; i <= sizes.length; i++) {
            sizes[i - 1] = (int) Math.pow(i, 2);
        }

        for (int i = 0; i < sizes.length; i++) {
            binaryInsertionSort.getTimeComplexity(sizes[i]);
            binaryInsertionSort.writeToFile(firstRun);

            countingSort.getTimeComplexity(sizes[i]);
            countingSort.writeToFile(firstRun);

            firstRun = false;
        }
    }

}