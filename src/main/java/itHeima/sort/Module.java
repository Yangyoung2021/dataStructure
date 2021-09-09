package itHeima.sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Module {
    public static void quickSort(Integer[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


    public static void main(String[] args) throws IOException {
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
        quickSort(array, 0, 99999);
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
