package itHeima.sort;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * 默认取第一个值作为临界值将数组数据分成两组，左边的小于临界值，右边大于临界值，从两端同时定义指针向中间移动
 * 右边取到小于临界值的时候就停止，让左边指针找到大于临界值的值停止，进行交换，如果不存在交换，让两者重合时就说明当前临界值的排序结束
 * 排序结束后将数据分组就成了有序数组
 */
public class QuickSort {

    public void sort(Integer[] array){
        int start = 0;
        int end = array.length - 1;
        group(array, start, end);
    }

    private void group(Integer[] array, int start, int end) {
        //递归出口和分组方法
        if (end <= start){
            return;
        }

        //定位到要与最边界的值交换的值的索引
        int exchangeIndex = location(array, start, end);

        //将前面的数据重新分组
        group(array, start, exchangeIndex - 1);

        //将后面的数据重新分组
        group(array, exchangeIndex + 1, end);

    }

    /**
     * 每次以第一个数作为临界值，将数据分成两组，左边小于临界值，右边大于临界值
     * @param array 要找到临界值的数组
     * @param start 左侧索引
     * @param end 右侧索引
     * @return 临界值的索引
     */
    private int location(Integer[] array, int start, int end) {
        //定义两个数据
        int temp;
        int value = array[start];
        //定义两个指针
        int left = start;
        int right = end;

        while(true){
            //{6,54,4,2,1,15,1,87,23,45,3,9,66}
            //定义右侧指针向左移动，拿到小于临界值的值时或者遇上左侧值就停止
            while(right > left && array[right] > value){
                right--;
            }

            //定义左侧指针向右移动，拿到小于临界值或者遇上右侧值就停止
            while(right > left && array[++left] < value){
            }

            if (right > left){
                //遇到了要交换的数据
                temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }else{
                //两个指针相遇了，停止循环
                break;
            }
        }
        //交换临界值和定位到的索引处的值
        temp = array[start];
        array[start] = array[left];
        array[left] = temp;

        return left;
    }

    @Test
    public void testQuickSort() throws IOException {
        Integer[] arr = {6,54,4,2,1,15,1,87,23,45,3,9,66};
        sort(arr);
        System.out.println(Arrays.toString(arr));

//        List<Integer> list = new ArrayList<>();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(BubbleSort.class.getClassLoader().getResourceAsStream("reverse_arr.txt")));
//        String line;
//        while((line = bufferedReader.readLine()) != null){
//            int result = Integer.parseInt(line);
//            list.add(result);
//        }
//        bufferedReader.close();
//
//        Integer[] array = new Integer[list.size()];
//        list.toArray(array);
//
//        long startTime = System.currentTimeMillis();
//        sort(array);
//        System.out.println(System.currentTimeMillis() - startTime);
    }

}
