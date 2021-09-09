package itHeima.sort;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 先对数组通过间隙分开，将间隙相连的数进行排序，然后再将间隙慢慢缩小，最后到一就变成了有序数组
 */
public class ShellSort {
    //定义间隙
    int gap;
    //定义临时变量
    int temp;

    public void sort(Integer[] array){
        //初始化间隙
        gap = 1;
        while(gap < array.length/2){
            gap = 2*gap + 1;
        }

        //循环将间隙相连的数排序，直到间隙为一
        while(gap >= 1){
            //找到需要排序的数
            for (int i = gap; i < array.length; i++) {
                //将数插入到正确的位置
                for (int j = i; j >= gap; j -= gap) {
                    if (array[j-gap] > array[j]){
                        temp = array[j];
                        array[j] = array[j-gap];
                        array[j-gap] = temp;
                    }else{
                        break;
                    }
                }
            }
            gap = gap/2;
        }
    }

    @Test
    public void testShellSort() throws IOException {
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

        int time = 0;
        for (int i = 0; i < 1000; i++) {
            long startTime = System.currentTimeMillis();
            sort(array);
            time += (System.currentTimeMillis() - startTime);
        }
        System.out.println(time/1000);
    }
}
