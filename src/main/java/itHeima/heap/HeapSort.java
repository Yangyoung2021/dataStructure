package itHeima.heap;

/**
 * 底层是基于完全二叉树
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> {

    //比较两个节点的大小
    private static boolean less(Comparable<Object>[] heap, int i, int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    //交换堆中索引i处和j处的值
    private static void exchange(Comparable<Object>[] heap, int i, int j){
        Comparable<Object> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //根据原数组构造出堆Heap
    private static void createHeap(Comparable<Object>[] source, Comparable<Object>[] heap){
        //将原数组的数据拷贝到堆中的数组中
        System.arraycopy(source, 0, heap, 1, source.length);
        //将堆中的前一半元素做下沉调整
        for (int i = heap.length/2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    //对source数组中的数据从大到小排序
    public static void sort(Comparable<Object>[] source){
        //构建堆
        Comparable<Object>[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        //创建一个变量记录未排序的最大索引
        int N = heap.length - 1;
        //通过循环交换索引1和最大的未排序的索引的值
        while(N != 1){
            //交换元素
            exchange(heap, N, 1);
            //将最大索引排除
            N--;
            //将1号节点下沉
            sink(heap, 1, N);
        }
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    //对heap中的target元素做下沉，范围是0~range
    private static void sink(Comparable<Object>[] heap, int target, int range){
        /*while(2*target <= range){
            int bigger;
            if (target*2 + 1 <= range){
                //存在右子树
                bigger = less(heap, 2*target + 1, 2*target) ? 2*target : 2*target + 1;
            }else{
                bigger = target*2;
            }
            if (!less(heap, target, bigger)){
                break;
            }
            //heap[target] < heap[bigger]
            exchange(heap, target, bigger);
            //heap[target] > heap[bigger]，继续往下走，直到下沉到最后
            target = bigger;
        }*/
        int bigger;
        while(target*2 <= range){
            if (target*2 + 1 <= range){
                //存在右子树
                bigger = (less(heap,target*2, target*2 + 1)) ? target*2 + 1 : target*2;
            }else{
                //不存在右子树
                bigger = target*2;
            }
            if (less(heap,target, bigger)){
                //根节点小于子节点中大的节点，将较大值和其进行交换
                exchange(heap, target, bigger);
            }else break; //根节点大于子树，直接返回
            target = bigger;
        }
    }

}
