package itHeima.symble;


/**
 * 有序符号表，LinkedHashMap底层原理
 */
public class OrderSymbolTable<K extends Comparable<K>, V>{
    //记录首节点
    private int N;
    //记录元素个数
    private final Node head;

    //私有节点内部类
    private class Node{
        private Node next;
        private final K key;
        private V value;
        public Node(K key, V value, Node next){
            this.key = key;
            this.next = next;
            this.value = value;
        }
    }

    //初始化方法
    public OrderSymbolTable(){
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    //获取符号表中键值对个数
    public int size(){
        return N;
    }

    //插入元素
    public void put(K key, V value){
        Node curr = this.head.next;
        Node prev = this.head;
        //通过比较key的大小来判断该插入的位置
        while (curr != null && key.compareTo(curr.key) > 0){
            prev = curr;
            curr = curr.next;
        }
        //判断当前有序符号表中是否存在这个key
        if (curr != null && key.compareTo(curr.key) == 0){
            curr.value = value;
            return;
        }
        //现在的curr就是要插入的地方
        prev.next = new Node(key, value, curr);
        //长度加一
        N++;
    }

    //获取键所对应的值
    public V get(K key){
        //拿到第一个对象节点(用来存放值的节点)
        Node curr = this.head.next;
        //循环遍历
        while(curr != null){
            if (curr.key.equals(key)){
                //找到了想要的节点
                return curr.value;
            }
            //指针后移
            curr = curr.next;
        }
        return null;
    }

    //删除指定键的键值对
    public void remove(K key){
        //拿到第一个对象节点(用来存放值的节点)
        Node curr = this.head;
        //循环遍历
        while(curr.next != null){
            if (curr.next.key.equals(key)){
                //当前节点为要找的节点的前一个节点,将当前节点的next直接设置为下下个节点
                curr.next = curr.next.next;
                //长度减一
                N--;
                return;
            }
            //指针后移
            curr = curr.next;
        }
    }

}
