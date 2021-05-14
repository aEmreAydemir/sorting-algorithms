package sort;

import java.util.HashMap;
import java.util.Map;

public class InsertionSort extends complexity {
    private double numberOfBasicOp;
    private int[] nums;
    Testing testing = new Testing();
    private Map<String, String> inputType = new HashMap<>();

    public InsertionSort() {
        inputType.put("best", "ascending");
        inputType.put("average", "random");
        inputType.put("worst", "descending");
    }

    @Override
    public void sort(int[] nums) {
        numberOfBasicOp = 0;
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            int key = nums[i];
            int j = i - 1;

            /* Move elements of nums[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0) {
                numberOfBasicOp++; // selected as basic operation
                if (nums[j] > key){
                    nums[j + 1] = nums[j];
                    j = j - 1;
                }else
                    break;
            }
            nums[j + 1] = key;
        }
        this.nums = nums;
    }

    @Override
    public double getNumberOfBasicOp() {
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
        return "InsertionSort";
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
