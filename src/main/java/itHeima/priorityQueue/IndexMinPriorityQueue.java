package itHeima.priorityQueue;

import java.util.Arrays;

/**
 * 基于最小堆的索引优先队列
 * @param <T>
 */
public class IndexMinPriorityQueue<T extends Comparable<T>>  {
    /*
    item【】数组中存储的是实际存放的索引与值
    pq【】数组中存放的是item【】数组中的索引，pq是堆有序的（每个节点都大于它的两个子节点）
    qp【】数组存放的是pq【】数组中的索引，并且qp的索引就是item的索引，但是qp数组和item数组中的值没有关系，
    ***不可以通过qp直接找到过着修改item中的值***
     */

    //记录堆中元素的个数
    private int N;
    //记录堆中存储元素的数组
    private final T[] item;
    //保存每个元素在在item数组中的索引，且为有序
    private final int[] pq;
    //保存pq数组的逆序，用pq的值为索引，索引作为值
    private final int[] qp;

    //构造方法，用来构建容量为capacity的数组
    public IndexMinPriorityQueue(int capacity){
        this.item = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.N = 0;

        //默认情况下将qp数组中所有元素复制为一
        Arrays.fill(qp, -1);
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    public boolean less(int i, int j){
        return item[pq[i]].compareTo(item[pq[j]]) < 0;
    }

    //判断索引优先队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //交换索引i处与索引j处的值
    private void exchange(int i, int j){
        //交换有序堆中的元素位置
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        //交换qp中元素位置，现在的pq【i】就是原来的pq【j】
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //获取队列的元素个数
    public int size(){
        return N;
    }

    //判断堆中索引k对应的值是否存在
    public boolean exist(int k){
        return qp[k] != -1;
    }

    //获取最小元素对应的索引
    public int minIndex(){
        return pq[1];
    }

    //插入元素
    public void insert(int i, T t){
        //判断当前索引是否存在
        if (exist(i)){
            throw new RuntimeException("该索引已存在，不能添加元素！");
        }
        //向item数组中添加元素
        item[i] = t;
        //向有序堆中添加元素（要进行上浮操作）
        pq[++N] = i;
        //向qp数组中添加元素
        qp[i] = N;
        //将堆中的第N个元素进行上浮操作
        swim(N);
    }

    //由于本类中的比较大小和交换位置都是基于pq数组(有序堆)的，所以上浮操作并没有变化
    private void swim(int n) {
        while (n > 1 && less(n, n/2)){
            //当前值小于其父节点
            exchange(n, n/2);
            n = n/2;
        }
    }

    //删除堆中的最小元素并返回该元素的索引
    public int delMin(){
        //保存最小元素的索引用于返回
        int minIndex = pq[1];
        //将item数组中的元素进行删除，可以省略，因为数组是直接赋值的，就算之前有也会直接覆盖
        item[minIndex] = null;
        //将qp数组中的值置为-1
        qp[minIndex] = -1;
        //交换与最后一个之间的位置
        exchange(1, N);

        //删除pq数组中的最大索引处的内容
        pq[N] = -1;

        //元素减一，一定要在下沉前面，不然到时就又回去了
        N--;
        //元素下沉
        sink(1);

        return minIndex;
    }

    //将元素i下沉到合适的位置
    private void sink(int i) {
        //确保最后一个子树没有出界
        while (i*2 <= N){
            int litter;
            //判断是否存在右子树，存在就让litter取二者较小值，不存在取左子树
            if (i*2 + 1 <= N){
                litter = less(i*2, i*2 + 1) ? i*2 : i*2 + 1;
            }else{
                litter = i*2;
            }

            //判断当前节点与较小值的大小关系来决定是否进行下沉
            if (less(litter, i)){
                //下沉
                exchange(litter, i);
                i = litter;
            }else break;
        }
    }

    //删除堆中的指定元素
    public void delete(int i){
        //拿到堆中要删除元素的item的索引
        int target = qp[i];
        //交换位置
        exchange(target, N);
        //删除pq中的内容
        pq[N] = -1;
        //删除qp中的内容
        qp[pq[N]] = -1;
        //删除item中的内容
        item[target] = null;
        //元素个数减一
        N--;
        //上浮下沉操作，由于删除的元素
        sink(target);
        swim(target);
    }

    //修改指定索引处的值
    public void update(int i, T t){
        //修改item处的值
        item[i] = t;
        //找到i在pq中的位置用来进行上浮和下沉操作
        int target = qp[i];
        //上浮和下沉操作
        sink(target);
        swim(target);
    }

}
