package sort;

import java.util.HashMap;
import java.util.Map;

public class BinaryInsertionSort extends complexity {
    private int numberOfBasicOp;
    private int[] nums;
    Testing testing = new Testing();
    private Map<String, String> inputType = new HashMap<>();

    public BinaryInsertionSort() {
        inputType.put("best", "ascending");
        inputType.put("average", "random");
        inputType.put("worst", "descending");
    }

    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        numberOfBasicOp = 0;
        for (int i = 1; i < n; ++i) {
            int key = nums[i];
            int insertedPosition = findPosition(nums, 0, i - 1, key);

            // shift all elements from insertedPosition to i-1'th element because all of them are bigger
            for (int j = i - 1; j >= insertedPosition; --j) {
                nums[j + 1] = nums[j];
            }
            // insert element at found position
            nums[insertedPosition] = key;
        }
        this.nums = nums;
    }

    // binary search to find position for new element
    private int findPosition(int[] nums, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            numberOfBasicOp++; // comparison is selected as the basic operation
            // look at the left side of the array
            if (key < nums[mid]) {
                end = mid - 1;
                // look at the right side of the array
            } else {
                start = mid + 1;
            }
        }

        return start;
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
        return "BinaryInsertionSort";
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
