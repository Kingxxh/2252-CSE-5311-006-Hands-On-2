import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class SortingBenchmarkWithChart {

    // 获取系统信息
    public static void printSystemInfo() {
        System.out.println("System Information:");
        System.out.println("CPU: " + System.getProperty("os.arch"));
        System.out.println("RAM: " + (Runtime.getRuntime().maxMemory() / (1024 * 1024)) + " MB");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println();
    }

    // 运行基准测试
    public static long benchmark(Runnable sortFunction, int[] array) {
        int[] copy = Arrays.copyOf(array, array.length); // 确保每次排序前数组一致
        long startTime = System.nanoTime();
        sortFunction.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        printSystemInfo();

        int[] sizes = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
        Random random = new Random();

        // 数据集，用于绘制图表
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // 测试插入排序
        System.out.println("Runtime for insertion_sort:");
        for (int size : sizes) {
            int[] array = random.ints(size, 1, 100).toArray();
            long time = benchmark(() -> SortingAlgorithms.insertionSort(array), array);
            System.out.printf("  Input size %d: %.6f seconds%n", size, time / 1e9);
            dataset.addValue(time / 1e9, "Insertion Sort", String.valueOf(size));
        }
        System.out.println();

        // 测试选择排序
        System.out.println("Runtime for selection_sort:");
        for (int size : sizes) {
            int[] array = random.ints(size, 1, 100).toArray();
            long time = benchmark(() -> SortingAlgorithms.selectionSort(array), array);
            System.out.printf("  Input size %d: %.6f seconds%n", size, time / 1e9);
            dataset.addValue(time / 1e9, "Selection Sort", String.valueOf(size));
        }
        System.out.println();

        // 测试冒泡排序
        System.out.println("Runtime for bubble_sort:");
        for (int size : sizes) {
            int[] array = random.ints(size, 1, 100).toArray();
            long time = benchmark(() -> SortingAlgorithms.bubbleSort(array), array);
            System.out.printf("  Input size %d: %.6f seconds%n", size, time / 1e9);
            dataset.addValue(time / 1e9, "Bubble Sort", String.valueOf(size));
        }

        // 创建折线图
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Sorting Algorithm Performance",
                "Input Size",
                "Time (seconds)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // 显示图表
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sorting Performance Chart");
        frame.setSize(800, 600);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
    }
}

class SortingAlgorithms {

    // 插入排序
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // 选择排序
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
