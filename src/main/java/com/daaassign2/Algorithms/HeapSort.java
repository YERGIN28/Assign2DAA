package com.daaassign2.Algorithms;


import com.daaassign2.Metrics.PerformanseTracker;

public class HeapSort {

    public static void sort(int[] arr, PerformanseTracker performanseTracker) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, performanseTracker);
        }


        for (int i = n - 1; i >= 0; i--) {
            performanseTracker.addSwap();
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, performanseTracker);
        }
    }

    private static void heapify(int[] arr, int n, int i, PerformanseTracker performanseTracker) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < n) {
            performanseTracker.addComparison();
            if (arr[left] > arr[largest])
                largest = left;
        }


        if (right < n) {
            performanseTracker.addComparison();
            if (arr[right] > arr[largest])
                largest = right;
        }


        if (largest != i) {
            performanseTracker.addSwap();
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest, performanseTracker);
        }
    }
}
