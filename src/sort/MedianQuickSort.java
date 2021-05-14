package sort;

import java.util.HashMap;
import java.util.Map;

public class MedianQuickSort extends complexity {
    private int[] nums;
    private static int numberOfBasicOp;
    // This method sorts an array and internally calls quickSort
    Testing testing = new Testing();
    private Map<String, String> inputType = new HashMap<>();

    public MedianQuickSort() {
        inputType.put("best", "ascending");
        inputType.put("average", "random");
        inputType.put("worst", "descending");
    }

    @Override
    public void sort(int[] arr) {
        numberOfBasicOp = 0;
        nums = arr;
        int left = 0;
        int right = nums.length - 1;

        quickSort(arr, left, right);
    }

    // This method is used to sort the array using quicksort algorithm.
    // It takes left and the right end of the array as two cursors
    private static void quickSort(int[] arr, int left, int right) {

        // If both cursor scanned the complete array, quicksort exits
        if (left >= right) {
            numberOfBasicOp++;
            return;
        }


        // Pivot using median of 3 approach
        int pivot = getMedian(arr, left, right);
        int partition = partition(arr, left, right, pivot);

        // Recursively, calls the quicksort with the different left and right parameters of the sub-array
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
    private static int partition(int[] arr, int left, int right, int pivot) {
        int leftCursor = left - 1;
        int rightCursor = right;
        while (leftCursor < rightCursor) {
            while (arr[++leftCursor] < pivot) ;
            while (rightCursor > 0 && arr[--rightCursor] > pivot) ;
            numberOfBasicOp++;
            if (leftCursor >= rightCursor) {
                break;
            } else {
                swap(arr, leftCursor, rightCursor);
            }
        }
        swap(arr, leftCursor, right);
        return leftCursor;
    }

    public static int getMedian(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center]) {
            swap(arr, left, center);
            numberOfBasicOp++;
        }


        if (arr[left] > arr[right]) {
            swap(arr, left, right);
            numberOfBasicOp++;
        }

        if (arr[center] > arr[right]) {
            swap(arr, center, right);
            numberOfBasicOp++;
        }

        swap(arr, center, right);
        return arr[right];
    }

    // This method is used to swap the values between the two given index
    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    @Override
    public int getNumberOfBasicOp() {
        return numberOfBasicOp;
    }

    @Override
    protected int[] getBestCaseIntArr(int n) {
        return testing.generateSortedIntArray(n);
    }

    @Override
    protected int[] getAverageCaseIntArr(int n) {
        return testing.generateRandomIntArray(n);
    }

    @Override
    protected int[] getWorstCaseIntArr(int n) {
        return testing.generateQuickSortMedianWorstCaseIntArray(n);
    }

    @Override
    protected String getAlgorithmName() {
        return "MedianQuickSort";
    }

    @Override
    protected int[] getIntArr() {
        return this.nums;
    }

    protected String getCase(String inputType) {
        return this.inputType.get(inputType);
    }

}
