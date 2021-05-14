package sort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class complexity {
    private Map<String, Object[]> complexity;

    public Map<String, Object[]> getTimeComplexity() {
        return getTimeComplexity(-1);
    } // -1 means use default array size in Testing

    public Map<String, Object[]> getTimeComplexity(int n) {
        Map<String, Object[]>complexity = new HashMap<>();

        int[] arrBest = getBestCaseIntArr(n);
        int[] arrAverage = getAverageCaseIntArr(n);
        int[] arrWorst = getWorstCaseIntArr(n);

        complexity.put("best", getInfo(arrBest, "best"));
        complexity.put("average", getInfo(arrAverage, "average"));
        complexity.put("worst", getInfo(arrWorst, "worst"));

        this.complexity = complexity;
        return complexity;
    }

    public Object[] getInfo(int[] arr, String inputType) {
        Object[] info = new Object[4];
        info[0] = arr.length;
        info[1] = execTime(arr);
        info[2] = getNumberOfBasicOp();
        info[3] = getCase(inputType);

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

    public void writeToFile(boolean firstRun) throws IOException {

        String filePath = "output\\" + getAlgorithmName() + ".csv";
        File f = new File(filePath);
        if (firstRun) {
            f.delete();
        }

        FileWriter writer;
        if (!f.exists()) {
            writer = new FileWriter(filePath);
            writer.append("size,time,count,input_type,type");
            writer.flush();
            writer.close();
        }

        writer = new FileWriter(filePath, true);
        FileWriter finalWriter = writer;
        this.complexity.forEach((key, value) -> {
            try {
                    finalWriter.append("\n" + value[0] + "," + value[1] + "," + value[2] + "," + value[3] + "," + key);
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

    protected abstract double getNumberOfBasicOp();

    protected abstract int[] getBestCaseIntArr(int n);

    protected abstract int[] getAverageCaseIntArr(int n);

    protected abstract int[] getWorstCaseIntArr(int n);

    protected abstract String getCase(String inputType);
}
