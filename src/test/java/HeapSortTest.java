
import com.daaassign2.HeapSort;
import com.daaassign2.util.Metrics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HeapSortTest {

    @Test
    public void testHeapSortSimple() {
        int[] arr = {4, 10, 3, 5, 1};
        Metrics metrics = new Metrics();
        HeapSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 3, 4, 5, 10}, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        Metrics metrics = new Metrics();
        HeapSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        Metrics metrics = new Metrics();
        HeapSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        Metrics metrics = new Metrics();
        HeapSort.sort(arr, metrics);
        assertArrayEquals(new int[]{}, arr);
    }
}
