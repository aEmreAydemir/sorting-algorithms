package sort;

import java.util.HashMap;
import java.util.Map;

public class HeapSort extends complexity {
    private int numberOfBasicOp;
    private int[] nums;
    Testing testing = new Testing();
    private Map<String, String> inputType = new HashMap<>();

    public HeapSort() {
        inputType.put("best", "ascending");
        inputType.put("average", "random");
        inputType.put("worst", "descending");
    }

    @Override
    public void sort(int[] nums) {
        numberOfBasicOp = 0;
        int n = nums.length;

        // creating heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, n, i);

        // extracting elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // move root to the end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
        this.nums = nums;
    }

    // heapify the subtree with root i (i=index in array, n=heap size)

    private void heapify(int array[], int n, int i) {
        int biggest = i; // the biggest is the root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // case: left child>root
        if (left < n && array[left] > array[biggest])
            biggest = left;

        // case: right child>biggest up to now
        if (right < n && array[right] > array[biggest])
            biggest = right;

        // if the biggest is not at the root
        if (biggest != i) {
            int swap = array[i];
            array[i] = array[biggest];
            array[biggest] = swap;

            // recursively heapify
            heapify(array, n, biggest);
        }
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
        return testing.generateReverseSortedIntArray(n);
    }

    @Override
    protected String getAlgorithmName() {
        return "HeapSort";
    }

    @Override
    protected int[] getIntArr() {
        return this.nums;
    }

    @Override
    protected String getCase(String inputType) {
        return this.inputType.get(inputType);
    }

}
