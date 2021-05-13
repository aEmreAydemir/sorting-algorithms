package sort;

public class CountingSort extends complexity {
    private int numberOfBasicOp;
    private int[] nums;
    Testing testing = new Testing();

    @Override
    public void sort(int[] nums) {
        numberOfBasicOp = 0;

        int size = nums.length;
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = nums[0];
        for (int i = 1; i < size; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        // Initialize count array with all zeros.
        int[] count = new int[max + 1];

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            numberOfBasicOp++;
            count[nums[i]]++;
        }

        // Store the cumulative count of each array
        for (int i = 1; i <= max; i++) {
            numberOfBasicOp++;
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            numberOfBasicOp++;
            output[count[nums[i]] - 1] = nums[i];
            count[nums[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            nums[i] = output[i];
        }
        this.nums = nums;
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
        return "CountingSort";
    }

    @Override
    protected int[] getIntArr() {
        return this.nums;
    }
}
