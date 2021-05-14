package sort;


import java.util.HashMap;
import java.util.Map;

public class MergeSort extends complexity {
    private int numberOfBasicOp;
    private int[] nums;
    Testing testing = new Testing();

    private Map<String, String> inputType = new HashMap<>();

    public MergeSort() {
        inputType.put("best", "ascending");
        inputType.put("average", "random");
        inputType.put("worst", "descending");
    }
    @Override
    public void sort(int[] nums) {
        this.nums = nums;
        mergeSorting(nums, 0, nums.length - 1);
    }

    private void mergeSorting(int[] nums, int little, int big) {
        if (big <= little) return;

        int mid = (little + big) / 2;
        mergeSorting(nums, little, mid);
        mergeSorting(nums, mid + 1, big);
        merge(nums, little, mid, big);
    }


    private void merge(int[] array, int little, int mid, int big) {
        // creating arrays for the left and right piece
        int[] leftPiece = new int[mid - little + 1];
        int[] rightPiece = new int[big - mid];

        // placing the elements of the actual array to the pieces
        for (int i = 0; i < leftPiece.length; i++)
            leftPiece[i] = array[little + i];
        for (int i = 0; i < rightPiece.length; i++)
            rightPiece[i] = array[mid + i + 1];

        // holding the indexes of left and right pieces
        int leftPieceI = 0;
        int rightPieceI = 0;

        // placing elements back to the actual array
        for (int i = little; i < big + 1; i++) {
            // in case there are missing elements in the left and right pieces, minimum of the two is placed
            if (leftPieceI < leftPiece.length && rightPieceI < rightPiece.length) {
                if (leftPiece[leftPieceI] < rightPiece[rightPieceI]) {
                    array[i] = leftPiece[leftPieceI];
                    leftPieceI++;
                } else {
                    array[i] = rightPiece[rightPieceI];
                    rightPieceI++;
                }
            } else if (leftPieceI < leftPiece.length) {
                // if the elements of rightPiece are placed in the array, place the elements of leftPiece
                array[i] = leftPiece[leftPieceI];
                leftPieceI++;
            } else if (rightPieceI < rightPiece.length) {
                // if the elements of leftPiece are placed in the array, place the elements of rightPiece
                array[i] = rightPiece[rightPieceI];
                rightPieceI++;
            }
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
        return "MergeSort";
    }

    @Override
    protected int[] getIntArr() {
        return this.nums;
    }

    protected String getCase(String inputType) {
        return this.inputType.get(inputType);
    }

}
