package itHeima.linear;

import java.util.Iterator;

/**
 * 栈对象，先进后出
 */
public class Stack<T> implements Iterable<T> {
    //栈长度（尺寸size）
    private int N;
    //栈的头节点
    private final Node<T> head;

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node<T> node = head;
            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public Object next() {
                node = node.next;
                return node.item;
            }
        };
    }

    static class Node<T>{
        private Node<T> next;
        private final T item;
        private Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head = new Node<>(null, null);
        this.N = 0;
    }

    public void clean(){
        this.head.next = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    //弹栈
    public T pop(){
        //获取原来的栈顶元素
        Node<T> oldFirst = this.head.next;
        if (oldFirst == null){
            return null;
        }
        //将原来的栈顶元素返回，让后将头节点指向原理啊栈顶元素的下一个节点
        this.head.next = oldFirst.next;
        //长度减一
        N--;
        //返回原来栈顶的数据
        return oldFirst.item;
    }

    //压栈
    public void push(T t){
        //获取原来的栈顶节点
        Node<T> oldFirst = this.head.next;
        //将新的节点设置为老节点的前一个节点和头节点的下一个节点
        this.head.next = new Node<>(t, oldFirst);
        //长度加一
        N++;
    }

}
