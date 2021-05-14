package sort;

import java.util.Random;

public class Testing {
    private final int defaultSize = 1000;
    private final int upperLimit = 10000;
    Random random = new Random();

    public int[] generateRandomIntArray() {
        return generateRandomIntArray(this.defaultSize);
    }

    // A method to generate an integer array with an arbitrary size. (default size is 1000; Elements of array are integers between 0 to 10000)
    public int[] generateRandomIntArray(int n) {
        n = n == -1 ? this.defaultSize : n;
        int[] list = new int[n];

        for (int i = 0; i < n; i++) list[i] = Math.max(1, random.nextInt(this.upperLimit - 1));

        return list;
    }

    // A method to generate an integer array with normal distribution. (mean = upperLimit/2 ; std = 2000)
    public int[] generateNormalDistribution() {
        return generateNormalDistribution(this.defaultSize);
    }

    public int[] generateNormalDistribution(int n) {
        n = n == -1 ? this.defaultSize : n;
        int[] list = new int[n];

        for (int i = 0; i < n; i++) list[i] = (int) Math.abs(random.nextGaussian() * 2000 + this.upperLimit / 2.0);
        return list;
    }


    public int[] generateExponentialDistribution() {
        return generateExponentialDistribution(this.defaultSize);
    }

    public int[] generateExponentialDistribution(int n) {
        double lambda = 1 / (this.upperLimit / 2.0);
        n = n == -1 ? this.defaultSize : n;
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            int num = (int) (Math.log(1 - random.nextDouble()) / (-lambda));
            list[i] = num >= this.upperLimit ? this.upperLimit - 1 : num;
        }
        return list;
    }


    public int[] generateSortedIntArray() {
        return generateSortedIntArray(this.defaultSize);
    }

    public int[] generateSortedIntArray(int n) {
        n = n == -1 ? this.defaultSize : n;
        int[] list = new int[n];
        for (int i = 1; i <= n; i++) list[i - 1] = Math.min(i, this.upperLimit - 1);

        return list;
    }

    public int[] generateReverseSortedIntArray() {
        return generateReverseSortedIntArray(this.defaultSize);
    }

    public int[] generateReverseSortedIntArray(int n) {
        n = n == -1 ? this.defaultSize : n;
        int[] list = new int[n];
        for (int i = 1; i <= n; i++) list[i - 1] = Math.min(n - i + 1, this.upperLimit - 1);

        return list;
    }

    public int[] generateSameElementIntArray() {
        return generateSameElementIntArray(this.defaultSize);
    }

    public int[] generateSameElementIntArray(int n) {
        n = n == -1 ? this.defaultSize : n;

        int[] list = new int[n];
        int value = Math.max(1, random.nextInt(this.upperLimit - 1));
        for (int i = 0; i < n; i++) list[i] = value;

        return list;
    }

    public int[] generateQuickSortMedianWorstCaseIntArray() {
        return generateQuickSortMedianWorstCaseIntArray(this.defaultSize);
    }

    public int[] generateQuickSortMedianWorstCaseIntArray(int n) {
        n = n == -1 ? this.defaultSize : n;

        int[] list = new int[n];

        for (int i = 1; i < n; i++) {
            if (i > Math.floor(n / 2.0)) list[i - 1] = i + 2;
            if (i == Math.floor(n / 2.0)) list[i - 1] = i - 1;
            else list[i - 1] = i - 2;
        }

        return list;
    }


}
