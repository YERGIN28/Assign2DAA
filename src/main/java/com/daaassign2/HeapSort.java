package com.daaassign2;


import com.daaassign2.util.Metrics;

public class HeapSort {

    public static void sort(int[] arr, Metrics metrics) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, metrics);
        }


        for (int i = n - 1; i >= 0; i--) {
            metrics.addSwap();
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, metrics);
        }
    }

    private static void heapify(int[] arr, int n, int i, Metrics metrics) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < n) {
            metrics.addComparison();
            if (arr[left] > arr[largest])
                largest = left;
        }


        if (right < n) {
            metrics.addComparison();
            if (arr[right] > arr[largest])
                largest = right;
        }


        if (largest != i) {
            metrics.addSwap();
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest, metrics);
        }
    }
}
