package itHeima.priorityQueue;

public class MinPriorityQueue<T extends Comparable<T>> {
    //创建用于存储数据的对象
    private T[] item;
    //标识队列的长度对象
    private int N;

    //构造方法
    public MinPriorityQueue(int capacity){
        this.item = (T[]) new Comparable[capacity];
        this.N = 0;
    }

    //获取队列中元素的个数
    public int size() {
        return N;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }
    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return item[i].compareTo(item[j]) < 0;
    }
    //交换队列中i处和j处的索引的值
    public void exchange(int i, int j){
        T temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }
    //先队列中插入元素
    public void insert(T t){
        item[++N] = t;
        swim(N);
    }
    //将元素上浮到合适的节点处
    private void swim(int n) {
        while(n > 1 &&less(n, n/2)){
            exchange(n, n/2);
            n = n/2;
        }
    }
    //将队列中的最小元素删除
    public T removeMin(){
        //获取最小元素用于返回对象
        T min = item[1];
        //交换元素
        exchange(1, N);
        //长度减一
        N--;
        //下沉
        sink(1);
        return min;
    }

    public void sink(int i) {
        while(i*2 <= N){
            //当前节点大于子树,进行交换
            int litter;
            if (2*i + 1 <= N){
                //存在右子树
                litter = less(i*2 + 1, i*2) ? i*2 + 1 : i*2;
            }else{
                litter = i*2;
            }

            if (less(i, litter)){
                break;
            }
            exchange(i, litter);
            i = litter;
        }
    }
}
