package sort;

import java.util.Random;

public class Testing {
    private int arraySize;
    private int upperLimit = 10000;

    public Testing() {
        this.arraySize = 1000;
    }

    // A method to generate an integer array with an arbitrary size. (default size is 1000; Elements of array are integers between 0 to 10000)
    public int[] generateRandomIntArray() {
        return generateRandomIntArray(this.arraySize);
    }

    public int[] generateRandomIntArray(int n) {
        int[] list = new int[n];

        Random random = new Random();

        for (int i = 1; i < n; i++) list[i] = random.nextInt(this.upperLimit);

        return list;
    }


    public int[] generateSortedIntArray() {
        return generateSortedIntArray(this.arraySize);
    }

    public int[] generateSortedIntArray(int n) {
        int[] list = new int[n];
        for (int i = 1; i <= n; i++) list[i-1] = Math.min(i, this.upperLimit - 1);

        return list;
    }

    public int[] generateReverseSortedIntArray() {
        return generateReverseSortedIntArray(this.arraySize);
    }

    public int[] generateReverseSortedIntArray(int n) {

        int[] list = new int[n];
        for (int i = 1; i <= n; i++) list[i-1] = Math.min(n - (i + 1), this.upperLimit - 1);

        return list;
    }

}
