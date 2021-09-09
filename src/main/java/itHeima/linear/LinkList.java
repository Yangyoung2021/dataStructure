package itHeima.linear;


import java.util.Iterator;

/**
 * 单向链表 增删快，查询慢
 * @param <T> 链表的泛型
 */
public class LinkList<T> implements Iterable<T> {
    //记录头节点
    private final Node head;
    //记录链表的长度
    private int N;

    //节点内部类
    private class Node{
        //存储的数据
        T item;
        //下一个节点
        Node next;

        //构造方法
        private Node (T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    //构造方法
    public LinkList(){
        //初始化头节点
        head = new Node(null, null);
        //初始化链表长度
        N = 0;
    }

    //清空链表
    public void clear(){
        //将头节点的指向去掉，链表即为空
        head.next = null;
        //将链表长度设置为零
        N = 0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //获取指定位置i处的元素
    public T get(int i){
        //设置第一个节点
        Node node = head.next;
        //通过第一个节点一直往下遍历，直到循环i次找到所要寻找的元素位置
        for (int index = 0; index < i; index++) {
            node = node.next;
        }
        //将第i个节点处的数据返回
        return node.item;
    }

    //向链表中添加元素
    public void insert(T t){
        //添加元素一定要添加一个Node元素
        Node newNode = new Node(t, null);
        //将最后一个节点的指向设置为当前节点
        Node node = this.head; //创建头节点
        while(node.next != null){ //循环遍历直到最后一个节点
            node = node.next;
        }
        node.next = newNode; //将新节点设置为最后一个节点的指向
        //元素个数加一
        N++;
    }

    //指定i位置处添加元素
    public void insert(int i, T t){
        //找到原始的i位置处的节点
        Node node = this.head;
        for (int index = 0; index < i; index++) {
            node = node.next;
        }
        //此时node即为原始的i-1位置处元素，现在要将node指向设置为新节点，新节点的指向设置为下一个节点（原本的i处节点）
        Node oldNodeI = node.next;
        //创建新节点，指向原来的i处的节点，将i-1处的节点指向新节点
        node.next = new Node(t,oldNodeI);
        //长度加一
        N++;
    }

    //删除指定位置i处的元素并返回
    public T remove(int i){
        //拿到头节点
        Node node = this.head;
        //找到i-1处的节点
        for (int index = 0; index < i; index++) {
            node = node.next;
        }
        //找到i处的节点
        Node targetNode = node.next;
        //找到目标节点的下一个节点
        node.next = targetNode.next;
        //长度减一
        N--;
        //返回数据
        return targetNode.item;
    }

    //查找元素第一次在链表出现的位置
    public int indexOf(T t){
        //获取头节点
        Node node = this.head;
        //遍历链表
        for (int index = 0; index < N; index++) {
            node = node.next;
            if (node.item.equals(t)){
                return index;
            }
        }
        //没有找到
        return -1;
    }

    //整个链表反转
    public void reverse(){
//        reverse(head.next);
//        head.next = reverseListDD(head.next);
//        head.next = reverseList(head.next);
        head.next = stackReverse(head.next);
    }

    private Node reverseList(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        //用来保存新的头节点，也就是原来的尾节点
        Node newHead = reverseList(head.next);
        //将递归的结果设置为当前节点的前一个节点
        head.next.next = head;
        //将当前节点的next置空，以便在第一个尾节点结束后让前一个节点作为尾节点
        head.next = null;
        return newHead;
    }

    /*
    一个链表中有多个节点Node
    每个节点Node包含一个数据data，一个next（指向下一个Node）

    将链表反转就是将尾结点变为头结点，头结点变成尾结点，中间的指向全部反转
     */
    //反转链表中的某个节点，并把反转后的节点返回
    public Node reverse(Node target){
        if (target.next == null){
            //此时的target就是尾结点，将其返回
            head.next = target;
            return target;
        }
        //将当前节点作为返回节点的下一个节点，并且把当前节点的下一个节点置空
        reverse(target.next).next = target;
        target.next = null;
        return target;
    }


    //实现迭代器方法
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

    //迭代法(双指针)
    public Node reverseListDD(Node head) {
        //定义两个指针
        Node prev = null;
        Node next;
        //将节点设置为当前节点
        Node curr = head;
        while(curr != null){
            //获取当前节点的下一个节点
            next = curr.next;
            //将前一个节点设置为下一个节点
            curr.next = prev;
            //将当前节点设置为前一个节点
            prev = curr;
            //将下一个节点设置为当前节点
            curr = next;
        }
        //返回前一个结点
        return prev;
    }

    //弹栈反转
    public Node stackReverse(Node head){
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (head.next != null){
            //将head.next压栈
            stack.push(head.next);
            head = head.next;
        }
        //保存头节点（原来的尾节点）
        Node firstNode = stack.pop();
        //将最先弹栈的节点作为起始点
        Node lastNode = firstNode;
        //遍历栈
        while(!stack.isEmpty()){
            //将弹栈内容存储到链表中
            lastNode.next = stack.pop();
            //将指针向后移动
            lastNode = lastNode.next;
        }
        //将最后一个节点的next置空
        lastNode.next = null;
        return firstNode;
    }

}
