package sort;

public class CountingSort extends complexity{
    private int numberOfBasicOp;

    public CountingSort() {

    }

    public void sort(int[] nums) {
        numberOfBasicOp = 0;
        int size = nums.length;
        int[] count = new int[size];
        int[] output = new int[size];
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                numberOfBasicOp++; // comparison selected as basic operation
                if (nums[i] < nums[j])
                    count[j]++;
                else
                    count[i]++;
            }
        }

        for (int i = 0; i < size; i++)
            output[count[i]] = nums[i];

    }

    public int getNumberOfBasicOp() {
        return numberOfBasicOp;
    }
}
