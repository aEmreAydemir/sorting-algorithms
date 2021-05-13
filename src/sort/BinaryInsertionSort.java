package sort;

public class BinaryInsertionSort extends complexity{
    private int numberOfBasicOp;

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

    public int getNumberOfBasicOp() {
        return numberOfBasicOp;
    }

    // For getting information about best, average and worst time complexity. Return value contains running time of sorting algorithm and count of the basic operation.

}
