package Algorithms;

import com.daaassign2.Algorithms.HeapSort;
import com.daaassign2.Metrics.PerformanseTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HeapSortTest {

    @Test
    public void testHeapSortSimple() {
        int[] arr = {4, 10, 3, 5, 1};
        PerformanseTracker performanseTracker = new PerformanseTracker();
        HeapSort.sort(arr, performanseTracker);
        assertArrayEquals(new int[]{1, 3, 4, 5, 10}, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanseTracker performanseTracker = new PerformanseTracker();
        HeapSort.sort(arr, performanseTracker);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        PerformanseTracker performanseTracker = new PerformanseTracker();
        HeapSort.sort(arr, performanseTracker);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        PerformanseTracker performanseTracker = new PerformanseTracker();
        HeapSort.sort(arr, performanseTracker);
        assertArrayEquals(new int[]{}, arr);
    }
}
