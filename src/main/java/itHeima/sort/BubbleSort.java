package itHeima.sort;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

    /**
     * 冒泡排序
     * @param array 要排序的数组
     */
    public static void bubbleSort(Integer[] array){

        /*
        排序逻辑：
            将每个数与下一个数比较，大于下一个就交换位置，小于就不变
         */
        int temp;
        //第一层循环：排序次数
        for (int i = 0; i < array.length - 1; i++) {
            //将第i大的数放到后面去
            for (int j = 0; j < array.length - 1; j++) {
                //判断当前值和后一个值的大小关系，若前者大就不换位置，否则交换位置
                if (array[j] > array[j+1]){
                    //前者大于后者，交换位置
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    @Test
    public void testBubble() throws IOException {
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
        bubbleSort(array);
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
