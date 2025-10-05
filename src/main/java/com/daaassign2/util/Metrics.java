package com.daaassign2.util;

public class Metrics {
    private long comparisons = 0;
    private long swaps = 0;
    private long allocations = 0;

    public void addComparison() {
        comparisons++;
    }

    public void addSwap() {
        swaps++;
    }

    public void addAllocation() {
        allocations++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getAllocations() {
        return allocations;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        allocations = 0;
    }
}
