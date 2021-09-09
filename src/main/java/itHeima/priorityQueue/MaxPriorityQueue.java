package itHeima.priorityQueue;


/**
 * 最大优先队列（基于堆）
 * @param <T>
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    //创建数组存放队列中的元素
    private T[] item;
    //记录堆中元素个数
    private int N;

    //无参构造方法
    public MaxPriorityQueue(int capacity){
        this.item = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //获取队列中的元素个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //判断队列中的i元素是否小于j元素
    public boolean less(int i, int j){
        return item[i].compareTo(item[j]) < 0;
    }

    //交换队列中i和j处的索引的值
    public void exchange(int i, int j){
        T temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }

    //向堆中插入一个数据，需要用到上浮算法
    public void insert(T t){
        item[++N] = t;
        swim(N);
    }

    //将元素线上浮动到合适的位置
    public void swim(int k){
        //当当前子树小于父节点时循环结束
        while(k > 1 && less(k/2, k)){
            //当前节点大于父节点
            exchange(k/2, k);
            //将节点向上浮动
            k = k/2;
        }
    }

    //将索引为i的元素从队列中移除
    public T removeMax(){
        //获取最大值用于返回对象
        T max = item[1];
        //交换最大值与最小值
        exchange(1, N);
        //长度减一
        N--;
        //元素下沉
        sink(1);
        //返回数据
        return max;
    }

    //将元素下沉到合适的位置
    public void sink(int k){
        //将当前节点和左右子树进行比较，如果其中有大于它的就进行交换
        while(2*k <= N){
            //定义左右子树中较大值的索引
            int bigger;
            //还没有出界
            if (2*k + 1 <= N){
                //存在右子树
                bigger = less(2*k + 1, 2*k) ? 2*k : 2*k + 1;
            }else{
                //不存在右子树
                bigger = 2*k;
            }

            if (less(k, bigger)){
                //父节点小于子树中的节点
                exchange(k, bigger);
                //继续下沉
                k = bigger;
            }else break;
        }
    }

}
