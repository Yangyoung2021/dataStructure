package itHeima.linear;

import java.util.Iterator;

/**
 * 双向链表
 * @param <T>
 */
public class TwoWayLinkList<T> implements Iterable<T>{
    //头结点
    private final Node head;
    //尾结点
    private Node last;
    //链表长度
    private int N;

    //内部类
    private class Node{
        //存储的数据
        private T item;
        //下一个节点的指向
        private Node next;
        //上一个节点的指向
        private Node prev;

        public Node(Node prev, T item, Node next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    //无参构造方法
    public TwoWayLinkList(){
        //初始化头结点
        this.head = new Node(null, null, null);
        //初始化尾结点
        this.last = null;
        //初始化链表长度
        this.N = 0;
    }

    //清空链表实现
    public void clear(){
        //头结点清空
        this.head.next = null;
        this.head.item = null;
        this.head.prev = null;

        this.last = null;
        this.N = 0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //获取第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return this.head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }

    //获取指定索引位置的数据
    public T get(int i){
        Node target = this.head.next;
        for (int j = 0; j < i; j++) {
            target = target.next;
        }
        return target.item;
    }

    //插入一个元素
    public void insert(T t){
        if (isEmpty()){
            //创建一个新节点作为尾结点并且让头结点指向尾结点
            this.last = new Node(this.head, t, null);
            this.head.next = this.last;
        }else{
            //直接创建一个新节点，并且让尾结点指向它
            Node oldLast = this.last;
            oldLast.next = new Node(oldLast, t, null);
            //再将新的节点设置为尾结点
            this.last = oldLast.next;
        }
        //长度加一
        N++;
    }

    //指定位置插入元素
    public void insert(int i, T t){
        //输入i小于零或者为空索引大于零
        if (i < 0 || isEmpty() && i > 0){
            throw new RuntimeException("索引越界异常");
        }
        //为空索引为零
        if (isEmpty() && i == 0){
            //创建一个新节点作为尾结点并且让头结点指向尾结点
            this.last = new Node(this.head, t, null);
            this.head.next = this.last;
        }
        //不为空且索引大于零
        if (!isEmpty() && i < N){
            /*
            先获取当前索引的元素，让其指向新创建的加入的元素，然后让新加入的元素执行原来索引的后一个元素
            原则上来说是不用动last的，但是如果i = N - 1就要将last换掉
             */
            Node node = this.head;
            for (int j = 0; j < i; j++) {
                node = node.next;
            } //得到的结果是原始的索引为i的节点
            //索引为i+1处的节点
            Node nextNode = node.next;
            //将原来的下一个节点设置为新的索引为i的next
            node.next = new Node(node, t, nextNode);
            //设置nextNode的prev为新的节点
            nextNode.prev = node.next;
        }else{
            //是尾结点
            //直接创建一个新节点
            Node oldLast = this.last;
            //并且让尾结点指向它
            oldLast.next = new Node(oldLast, t, null);
            //再将新的节点设置为尾结点
            this.last = oldLast.next;
        }
        //长度加一
        N++;
    }

    //删除指定位置元素
    public T remove(int i){
        if (i < 0){
            throw new RuntimeException("索引不能小于零！！");
        }
        if (i == 0){
            /*
            将头结点原始0索引节点的下一个节点
             */
            //获取第一个节点
            Node first = this.head.next;
            //将第二个节点设置为头结点的next
            this.head.next = first.next;
            //将第二个节点的prev设置为头结点
            first.next.prev = this.head;
            //长度减一
            N--;
            //返回数据
            return first.item;
        }else{
            //索引大于零
            Node target = this.head;
            //遍历
            for (int j = 0; j < i + 1; j++) {
                target = target.next;
            } //要加一拿到的才是作为索引的值
            //获取目标的上一个节点
            Node prevNode = target.prev;
            //将前一个的next设置为target的next
            prevNode.next = target.next;
            //将target的next的prev设置为prev
            target.next.prev = prevNode;
            //长度减一
            N--;
            //返回数据
            return target.item;
        }
    }

    //获取首次出现item处的索引值
    public int indexOf(T item){
        Node node = this.head;
        for (int i = 0; i < N; i++) {
            node = node.next;
            if (node.item.equals(item)){
                return i;
            }
        }
        return -1;
    }

    //迭代器遍历
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node node = head;
            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                node = node.next;
                return node.item;
            }
        };
    }

}
