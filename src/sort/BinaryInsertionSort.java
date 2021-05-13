package sort;

public class BinaryInsertionSort {
    Testing testing = new Testing() {
        @Override
        public int[] generateRandomIntArray() {
            return super.generateRandomIntArray();
        }
    };

    public BinaryInsertionSort() {

    }

    public static void binaryInsertionSort(int[] nums) {
        int length = nums.length;

        for (int i = 1; i < length; ++i) {
            int key = nums[i];
            int insertedPosition = findPosition(nums, 0, i - 1, key);

            for (int j = i - 1; j >= insertedPosition; --j) {
                nums[j + 1] = nums[j];
            }

            nums[insertedPosition] = key;
        }
    }

    public static int findPosition(int[] nums, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

}
