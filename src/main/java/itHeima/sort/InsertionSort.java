package itHeima.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 将整个数组分为两个数组，从第一个数开始作为已排序的数组，后面作为未排序的数组，将后面的数插入前面的数组
 */
public class InsertionSort {

    public void insertionSort(Integer[] array){
        int temp;
        //第一个循环，定义找到要插入的数
        for (int i = 1; i < array.length; i++) {
            //第二层循环，将数插入到正确的位置
            for (int j = i; j >=1 ; j--) {
                if (array[j-1] > array[j]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    @Test
    public void testInsertionSort(){
        Integer[] arr = {6,54,4,2,1,15,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
