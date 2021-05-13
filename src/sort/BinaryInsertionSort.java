package sort;

public class BinaryInsertionSort {
    private final int[] nums;

    public BinaryInsertionSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {
        int[] nums = this.nums;
        int length = nums.length;

        for (int i = 1; i < length; ++i) {
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
    public int findPosition(int[] nums, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
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

    public void print() {
        int[] nums = this.nums;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
