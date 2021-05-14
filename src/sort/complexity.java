package sort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class complexity {
    private Map<String, long[]> complexity;

    public Map<String, long[]> getTimeComplexity() {
        return getTimeComplexity(-1);
    } // -1 means use default array size in Testing

    public Map<String, long[]> getTimeComplexity(int n) {
        Map<String, long[]> complexity = new HashMap<>();

        int[] arrBest = getBestCaseIntArr(n);
        int[] arrAverage = getAverageCaseIntArr(n);
        int[] arrWorst = getWorstCaseIntArr(n);

        complexity.put("best", getInfo(arrBest));
        complexity.put("average", getInfo(arrAverage));
        complexity.put("worst", getInfo(arrWorst));

        this.complexity = complexity;
        return complexity;
    }

    public long[] getInfo(int[] arr) {
        long[] info = new long[3];
        info[0] = arr.length;
        info[1] = execTime(arr);
        info[2] = getNumberOfBasicOp();

        return info;
    }


    public long execTime(int[] arr) {
        long startTime = System.nanoTime();
        sort(arr);
        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime);

        return durationInMillis;
    }

    public void print() {
        int[] nums = getIntArr();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");

        }
    }

    public void writeToFile(boolean first_run) throws IOException {

        String filePath = "output\\" + getAlgorithmName() + ".csv";
        File f = new File(filePath);
        if (first_run) {
            f.delete();
        }

        FileWriter writer;
        if (!f.exists()) {
            writer = new FileWriter(filePath);
            writer.append("size,time,count,type");
            writer.flush();
            writer.close();
        }

        writer = new FileWriter(filePath, true);
        FileWriter finalWriter = writer;
        this.complexity.forEach((key, value) -> {
            try {
                finalWriter.append("\n" + value[0] + "," + value[1] + "," + value[2] + "," + key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.flush();
        writer.close();
    }

    protected abstract String getAlgorithmName();

    protected abstract int[] getIntArr();

    protected abstract void sort(int[] arr);

    protected abstract int getNumberOfBasicOp();

    protected abstract int[] getBestCaseIntArr(int n);

    protected abstract int[] getAverageCaseIntArr(int n);

    protected abstract int[] getWorstCaseIntArr(int n);
}
