package sort;

public class MedianQuickSort extends complexity{
    public static int[] a;
    private static int numberOfBasicOp;
    // This method sorts an array and internally calls quickSort
    Testing testing = new Testing();

    @Override
    public void sort(int array[]){
        numberOfBasicOp=0;
        a=array;
        int left = 0;
        int right = a.length-1;

        quickSort(left, right);
    }

    // This method is used to sort the array using quicksort algorithm.
    // It takes left and the right end of the array as two cursors
    private static void quickSort(int left,int right){

        // If both cursor scanned the complete array, quicksort exits
        if(left >= right){
            numberOfBasicOp++;
            return;
        }


        // Pivot using median of 3 approach
        int pivot = getMedian(left, right);
        int partition = partition(left, right, pivot);

        // Recursively, calls the quicksort with the different left and right parameters of the sub-array
        quickSort(left, partition-1);
        quickSort(partition+1, right);
    }

    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
    private static int partition(int left,int right,int pivot){
        int leftCursor = left-1;
        int rightCursor = right;
        while(leftCursor < rightCursor){
            while(a[++leftCursor] < pivot);
            while(rightCursor > 0 && a[--rightCursor] > pivot);
            if(leftCursor >= rightCursor){
                numberOfBasicOp++;
                break;
            }else{
                numberOfBasicOp++;
                swap(leftCursor, rightCursor);
            }
        }
        swap(leftCursor, right);
        return leftCursor;
    }

    public static int getMedian(int left,int right){
        int center = (left+right)/2;

        if(a[left] > a[center]) {
            swap(left,center);
            numberOfBasicOp++;
        }


        if(a[left] > a[right]) {
            swap(left, right);
            numberOfBasicOp++;
        }

        if(a[center] > a[right]) {
            swap(center, right);
            numberOfBasicOp++;
        }

        swap(center, right);
        return a[right];
    }

    // This method is used to swap the values between the two given index
    public static void swap(int left,int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    @Override
    protected String getAlgorithmName() {
        return null;
    }

    @Override
    protected int[] getIntArr() {
        return new int[0];
    }

    @Override
    protected int getNumberOfBasicOp() {
        return numberOfBasicOp;
    }

    @Override
    protected int[] getBestCaseIntArr(int n) {
        return new int[0];
    }

    @Override
    protected int[] getAverageCaseIntArr(int n) {
        return new int[0];
    }

    @Override
    protected int[] getWorstCaseIntArr(int n) {
        return new int[0];
    }
}
