package itHeima.linear;

import java.util.Iterator;

/**
 * 队列（先进先出，后进后出）
 */
public class Queue<T> implements Iterable<T> {
    //队列长度
    private Integer N;
    //首节点（头节点）
    private final Node head;
    //尾节点
    private Node last;

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

    //内部类
    private class Node{
        private Node next;
        private T item;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    //无参构造器
    public Queue(){
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //获取队列长度
    public int length(){
        return N;
    }

    //向队列中插入元素
    public void enqueue(T t){
        if (isEmpty()){
            //原来为空就把头节点直接指向新建立的节点，并把它设置为尾节点
            this.last = new Node(t, null);
            head.next = this.last;
        }else{
            //获取原来的尾节点
            Node oldLast = this.last;
            //将新建立的节点设置为尾节点
            this.last = new Node(t, null);
            //将原来的尾节点指向新的尾节点
            oldLast.next = this.last;
        }
        //长度加一
        N++;
    }

    //移除队列中的元素
    public T dequeue(){
        //判断队列是否为空，空就返回null
        if (isEmpty()) return null;
        //获取原来的尾节点
        Node oldFirst = this.head.next;
        //将新的尾节点设置为原来尾节点的next
        this.head.next = oldFirst.next;
        //长度减一
        N--;
        //判断长度减少后是否为空，为空将尾节点设置为空
        if (isEmpty()) this.last = null;

        return oldFirst.item;
    }
}
