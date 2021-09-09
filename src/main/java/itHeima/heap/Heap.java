package itHeima.heap;


import java.util.Iterator;

/**
 * 底层是基于完全二叉树的实现，但是左右子树无序
 * @param <T>
 */
public class Heap<T extends Comparable<T>> implements Iterable<T> {
    //存储堆中的元素
    private final T[] item;
    //记录堆的长度
    private int N;

    //构造方法
    public Heap(int capacity){
        this.item = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    //判断堆中索引i处的值是否小于索引j处的值
    public boolean less(int i, int j){
        return item[i].compareTo(item[j]) < 0 ;
    }

    //交换堆中索引i处和索引j处的值
    public void exchange(int i, int j){
        T temp;
        temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }

    //往堆中添加一个元素
    public void insert(T t){
        /*
        添加时需要注意如果当前元素要大于父节点需要进行上浮（与父节点交换位置）操作
         */
        item[++N] = t;
        if (N > 1) swim(N);
    }

    //使用上浮算法，使插入的索引找到正确的位置
    public void swim(int k){
        //通过循环比较使得其与父节点位置正确放置
        while(k/2 >= 1 &&!less(k, k/2)){
            exchange(k, k/2);
            k = k/2;
        }
    }

    //删除堆中的根节点
    public T delMax(){
        if (N == 0) return null;
        //获取根节点的值用于方法返回
        T max = item[1];
        //交换位置
        exchange(1,N);
        item[N] = null;
        //元素减一
        N--;
        int index = 1;
        sink(index);
        return max;
    }

    //元素下沉方法
    private void sink(int target) {
        //判断传进来的作为根节点的值是否与两个子树相比是最大值，是就不交换位置，否则交换位置
        /*int bigger;
        while(index*2 + 1 <= N && less(index, (less(index*2, index*2 + 1)) ? index*2 + 1 : index*2)){
            bigger = (less(index*2, index*2 + 1)) ? index*2 + 1 : index*2 ;
            exchange(index, bigger);
            index = bigger;
        }*/

        int bigger;
        while(target*2 <= N){
            if (target*2 + 1 <= N){
                //存在右子树
                bigger = (less(target*2, target*2 + 1)) ? target*2 + 1 : target*2;
            }else{
                //不存在右子树
                bigger = target*2;
            }
            if (less(target, bigger)){
                //根节点小于子节点中大的节点，将较大值和其进行交换
                exchange(target, bigger);
            }else break; //根节点大于子树，直接返回
            target = bigger;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int num = 1;
            @Override
            public boolean hasNext() {
                return num <= N;
            }

            @Override
            public T next() {
                return item[num++];
            }
        };
    }
}
