package itHeima.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
选择排序
 */
public class SelectSort {
    /*
    逻辑分析：
        选出最小的放到前面
     */
    public void selectSort(Integer[] array){
        int temp;
        //循环次数
        for (int i = 0; i < array.length - 1; i++) {
            //要比较的数组
            for (int j = i + 1; j < array.length; j++) {
                //如果前者大于后者就交换数据
                if (array[i] > array[j]){
                    //交换数据
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                //此时array[i]就是最小值
            }
        }
    }

    @Test
    public void testSelectSort(){
        Integer[] arr = {1,6,54,4,88,2,1,15};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
