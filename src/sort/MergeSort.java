package sort;


public class MergeSort extends complexity{
    private int numberOfBasicOp;
    private int[] nums;
    Testing testing= new Testing();


    @Override
    public void sort(int []nums){
        mergesorting(nums, 0, nums.length-1);
    }

    private void mergesorting(int[] nums, int little, int big) {
        if (big <= little) return;

        int mid = (little+big)/2;
        mergesorting(nums, little, mid);
        mergesorting(nums, mid+1, big);
        merge(nums, little, mid, big);
    }


    private void merge(int[] array, int little, int mid, int big) {
        // creating arrays for the left and right piece
        int leftPiece[] = new int[mid - little + 1];
        int rightPiece[] = new int[big - mid];

        // placing the elements of the actual array to the pieces
        for (int i = 0; i < leftPiece.length; i++)
            leftPiece[i] = array[little + i];
        for (int i = 0; i < rightPiece.length; i++)
            rightPiece[i] = array[mid + i + 1];

        // holding the indexes of left and right pieces
        int leftpieceI = 0;
        int rightpieceI = 0;

        // placing elements back to the actual array
        for (int i = little; i < big + 1; i++) {
            // in case there are missing elements in the left and right pieces, minimum of the two is placed
            if (leftpieceI < leftPiece.length && rightpieceI < rightPiece.length) {
                if (leftPiece[leftpieceI] < rightPiece[rightpieceI]) {
                    array[i] = leftPiece[leftpieceI];
                    leftpieceI++;
                } else {
                    array[i] = rightPiece[rightpieceI];
                    rightpieceI++;
                }
            } else if (leftpieceI < leftPiece.length) {
                // if the elements of rightPiece are placed in the array, place the elements of leftPiece
                array[i] = leftPiece[leftpieceI];
                leftpieceI++;
            } else if (rightpieceI < rightPiece.length) {
                // if the elements of leftPiece are placed in the array, place the elements of rightPiece
                array[i] = rightPiece[rightpieceI];
                rightpieceI++;
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


/*
 public static void main(String args[]) {

    int[] array = new int[]{5, 6, 7, 2, 4, 1, 7};
    mergesort(array, 0, array.length-1);
    System.out.println(Arrays.toString(array));

}

 public static void sort(int[] nums, int little, int big) {
        if (big <= little) return;

        int mid = (little+big)/2;
        sort(nums, little, mid);
        sort(nums, mid+1, big);
        merge(nums, little, mid, big);
    }
*/


}
