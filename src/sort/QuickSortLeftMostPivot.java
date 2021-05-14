package sort;
import java.util.Arrays;

public class QuickSortLeftMostPivot extends complexity {

    private int numberOfBasicOp;
    /**
     This is the initial setup method for quicksort algorithm. Give this method your array only. It ill invoke the
     sort algorithm by starting with left most element
     */
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * Quick sort the given array starting from index
     * left and right
     *
     * Uses the first element in the array as the pivot
     * It uses a recursive approach
     */
    private void sort(int[] array, int l, int r) {
        if (l < r) {

            // select pivot element (left-most)
            int pivot = array[l];
            // partition and shuffle around pivot
            int i = l;
            int j = r;
            while (i < j) {
                // move right to avoid pivot element
                i += 1;
                // scan right: find elements greater than pivot
               numberOfBasicOp++;
                while (i <= r && array[i] < pivot) {
                    i += 1;
                    numberOfBasicOp++;
                }
                // scan left: find elements smaller than pivot
                while (j >= l && array[j] > pivot) {
                    j -= 1;
                    numberOfBasicOp++;
                }
                if (i <= r && i < j) {
                    // swap around pivot
                    swap(array, i, j);
                    numberOfBasicOp++;
                }
            }
            // put pivot in correct place
            swap(array, l, j);
            // sort partitions
            sort(array, l, j - 1);
            sort(array, j + 1, r);
        }
    }

    /**
     * Swap elements at indexes i and j
     * in the give array
     */
    private void swap(int[] array, int i, int j) {
        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    @Override
    protected String getAlgorithmName() {
        return "quick sort using left most element as pivot";
    }

    @Override
    protected int[] getIntArr() {
        return ;
    }

    @Override
    protected int getNumberOfBasicOp() {
        return numberOfBasicOp;
    }

    @Override
    protected int[] getBestCaseIntArr(int n) {
        return new int[0];
    }

    @Override
    protected int[] getAverageCaseIntArr(int n) {
        return new int[0];
    }

    @Override
    protected int[] getWorstCaseIntArr(int n) {
        return new int[0];
    }
}
