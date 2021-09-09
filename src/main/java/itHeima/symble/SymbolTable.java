package itHeima.symble;


/**
 * 符号表，用来存储键值对形式的数据，Map系列底层原理
 */
public class SymbolTable<K, V>{
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
    public SymbolTable(){
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    //获取符号表中键值对个数
    public int size(){
        return N;
    }

    //插入元素
    public void put(K key, V value){
        //判断是否存在当前的键值对
        if (get(key) == null){
            //不存在当前键

            //获取原来的第一个节点
            Node oldFirst = this.head.next;
            //将头节点的next设置为 新创建的节点
            Node newNode = new Node(key, value, null);
            this.head.next = newNode;
            //将新的节点指向原理啊第一个节点
            newNode.next = oldFirst;
            //长度加一
            N++;
        }else{
            //当前已存在该键

            //想要修改值就要拿到node对象
            Node n = this.head.next;
            while(n != null){
                //n代表的是第一个节点对象，如果将指针先向后移会导致第一个键值对拿不到
                if (n.key.equals(key)){
                    //拿到了当前重复的键，将值进行修改
                    n.value = value;
                    return;
                }
                n = n.next;
            }
        }
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
