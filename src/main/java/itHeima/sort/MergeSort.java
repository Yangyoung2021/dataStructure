package itHeima.sort;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 采用分治的概念，先将数组分组，再将分组好的小数组排好序，然后将小数组归并就成了有序数组
 */
public class MergeSort {

    private Integer[] assist;

    public void sort(Integer[] array){

        assist = new Integer[array.length];

        int start = 0;
        int end = array.length - 1;
        group(array, start, end);
    }

    //分组
    private void group(Integer[] array, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = start + (end - start)/2;

        //将前一段分组
        group(array, start,mid);
        //将后一段分组
        group(array, mid + 1, end);

        //归并
        merge(array, start, mid, end);
    }

    //归并
    private void merge(Integer[] array, int start, int mid, int end) {
        /*
        归并逻辑分析：
            创建一个和传入数组相同大小的空数组来作为辅助数组，将排好的数据赋值到原数组
         */
        //创建三个指针

        //前面数组的索引
        int former = start;
        //后面数组的索引
        int latter = mid + 1;
        //辅助数组的索引
        int index = start;

        //循环给辅助数组赋值，直到两个数组中一个索引走到了最后
        while (former <= mid && latter <= end){
            assist[index++] = (array[former] > array[latter]) ? array[latter++] : array[former++];
        }

        //将另一个数组中的数直接赋值给辅助数组
        while (former <= mid){
            assist[index++] = array[former++];
        }

        //将另一个数组中的数直接赋值给辅助数组
        while (latter <= end){
            assist[index++] = array[latter++];
        }

        //将数据复制到原数组
        if (end + 1 - start >= 0) System.arraycopy(assist, start, array, start, end + 1 - start);

    }

    @Test
    public void testMergeSort() throws IOException {
//        Integer[] arr = {6,54,4,2,1,15,1};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));


        List<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(BubbleSort.class.getClassLoader().getResourceAsStream("reverse_arr.txt")));
        String line;
        while((line = bufferedReader.readLine()) != null){
            int result = Integer.parseInt(line);
            list.add(result);
        }
        bufferedReader.close();

        Integer[] array = new Integer[list.size()];
        list.toArray(array);

        long startTime = System.currentTimeMillis();
        sort(array);
        System.out.println(System.currentTimeMillis() - startTime);
    }


}
