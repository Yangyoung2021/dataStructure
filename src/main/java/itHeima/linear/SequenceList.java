package itHeima.linear;


import java.util.Iterator;

/**
 * 定义有序线性表，List系列集合底层原理
 */
public class SequenceList<T> implements Iterable<T> {
    //储存元素的数组
    private T[] elements;
    //记录当前元素的个数(length)
    private int N;
    //初始化容量，当存在添加和删除操作时进行自动扩容和缩容作用
    private int capacity;

    //构造方法
    public SequenceList(int capacity){
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        N = 0;
        System.out.println("数组初始化完成，数组长度为："+elements.length);
    }

    //将线性表置空
    public void clear(){
        N = 0;
    }

    //判断线性表是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //获取线性表的长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        if (i < 0 || i >= N){
            throw  new RuntimeException("当前元素不存在");
        }
        return elements[i];
    }

    //插入元素
    public void insert(T t){
        if (N == elements.length){
            //自动扩容
            T[] newElements = (T[]) new Object[capacity*2];
            //数组复制，从原数组的0索引位置开始复制放到新数组的0索引位置开始，直到原数组索引的长度为element.length
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            this.elements = newElements;
        }
        elements[N++] = t;

        System.out.println("插入元素  "+t+"  后数组容量大小为：" + elements.length);
    }

    //在i出插入元素t
    public void insert(T t, int i){
        if (i >= elements.length || i < 0){
            throw new RuntimeException("索引越界异常");
        }
        if (N == elements.length){
            //自动扩容
            T[] newElements = (T[]) new Object[capacity*2];
            //数组复制，从原数组的0索引位置开始复制放到新数组的0索引位置开始，复制元素的个数为element.length
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            this.elements = newElements;
        }
        //将原来索引为i与其之后的数据都向后移一位
        if (N + 1 - i >= 0) System.arraycopy(elements, i - 1, elements, i, N + 1 - i);
        elements[i] = t;
        //长度加一
        N++;


        System.out.println("指定位置插入元素  "+t+"  后数组容量大小为：" + elements.length);
    }

    //删除指定位置处的元素，并将删除的元素返回
    public T remove(int i){
        if (i > elements.length || i < 0){
            throw new RuntimeException("索引越界！！");
        }

        //记录指定位置的值，用于返回
        T result = elements[i];
        //将目标元素后的数索引减一
        if (N + 1 - (i + 1) >= 0) System.arraycopy(elements, i + 1, elements, i + 1 - 1, N + 1 - (i + 1));

        //长度减一
        N--;
        //判断是否当前数组容量达到初始长度的1/4，不足就自动缩容
        double num = (double) elements.length / 4;
        if (N < num){
            //自动扩容
            T[] newElements = (T[]) new Object[capacity/2];
            //数组复制，从原数组的0索引位置开始复制放到新数组的0索引位置开始，直到原数组索引的长度为element.length
            System.arraycopy(elements, 0, newElements, 0, N);
            this.elements = newElements;
        }
        return result;
    }

    //查找t元素第一次出现的位置
    public int indexOf(T t){
        if (t == null){
            throw new RuntimeException("空指针异常");
        }
        for (int i = 0; i < N; i++) {
            if (elements[i].equals(t)){
                return i;
            }
        }
        return -1;
    }


    //实现迭代器方法
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < N;
            }

            @Override
            public T next() {
                return elements[cursor++];
            }
        };
    }
}
