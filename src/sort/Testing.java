package sort;

import java.util.Random;

public class Testing {
    private int arraySize;
    private int upperLimit = 10000;

    public Testing(int arraySize) {
        this.arraySize = arraySize;
    }

    public Testing() {
        this.arraySize = 1000;
    }

    // A method to generate an integer array with an arbitrary size. (default size is 1000; Elements of array are integers between 0 to 10000)
    public int[] generateRandomIntArray() {
        int n = this.arraySize;

        int[] list = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) list[i] = random.nextInt(this.upperLimit);

        return list;
    }

    public int[] generateSortedIntArray() {
        int n = this.arraySize;

        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = i;

        return list;
    }

    public int[] generateReverseSortedIntArray() {
        int n = this.arraySize;

        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = n - (i + 1);

        return list;
    }

}
