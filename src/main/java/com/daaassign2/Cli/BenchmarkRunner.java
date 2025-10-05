package com.daaassign2.Cli;


import com.daaassign2.Algorithms.HeapSort;
import com.daaassign2.Metrics.PerformanseTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        String outputFile = "metrics_heapsort.csv";
        int[] sizes = {100, 1000, 5000, 10000};

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("algorithm,n,time_ns,comparisons,swaps,allocations");

            for (int n : sizes) {
                int[] arr = generateRandomArray(n);
                PerformanseTracker performanseTracker = new PerformanseTracker();

                long start = System.nanoTime();
                HeapSort.sort(arr, performanseTracker);
                long end = System.nanoTime();

                long duration = end - start;

                writer.printf("heapsort,%d,%d,%d,%d,%d%n",
                        n,
                        duration,
                        performanseTracker.getComparisons(),
                        performanseTracker.getSwaps(),
                        performanseTracker.getAllocations());

                System.out.printf(" n=%d sorted in %.3f ms%n", n, duration / 1_000_000.0);
            }

            System.out.println(" Results saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
}
