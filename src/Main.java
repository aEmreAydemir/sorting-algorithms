import sort.*;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        CountingSort countingSort = new CountingSort();
        HeapSort heapSort = new HeapSort();
        MedianQuickSort medianQuickSort = new MedianQuickSort();
        MergeSort mergeSort = new MergeSort();
        QuickSortLeftMostPivot quickSortLeftMostPivot = new QuickSortLeftMostPivot();
        InsertionSort insertionSort= new InsertionSort();

        boolean firstRun = true;

        int[] sizes = new int[130]; // sample sizes
        for (int i = 1; i <= sizes.length; i++) {
            sizes[i - 1] = (int) Math.pow(i, 2);
        }

        for (int i = 0; i < sizes.length; i++) {
            binaryInsertionSort.getTimeComplexity(sizes[i]);
            binaryInsertionSort.writeToFile(firstRun);

            countingSort.getTimeComplexity(sizes[i]);
            countingSort.writeToFile(firstRun);

            heapSort.getTimeComplexity(sizes[i]);
            heapSort.writeToFile(firstRun);

            mergeSort.getTimeComplexity(sizes[i]);
            mergeSort.writeToFile(firstRun);

            medianQuickSort.getTimeComplexity(sizes[i]);
            medianQuickSort.writeToFile(firstRun);

            quickSortLeftMostPivot.getTimeComplexity(sizes[i]);
            quickSortLeftMostPivot.writeToFile(firstRun);

            insertionSort.getTimeComplexity(sizes[i]);
            insertionSort.writeToFile(firstRun);

            firstRun = false;
        }
    }

}