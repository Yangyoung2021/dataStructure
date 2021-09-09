package dateSource.tree;

import itHeima.heap.HeapSort;

import java.util.Arrays;

public class TestHeapSort {
    public static void main(String[] args) {
        Comparable[] array = {12,4,2,2,54,42,1,6,56};
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
