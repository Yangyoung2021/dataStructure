package itHeima.tree;


/**
 * 红黑树
 * @param <K> 键
 * @param <V> 值
 */
public class RedBlackTree<K extends Comparable<K>, V> {
    //存储根节点
    private Node root;
    //存储元素个数
    private int N;
    //红色链接
    private static final boolean RED = true;
    //黑色链接
    private static final boolean BLACK = false;

    private class Node{
        //存储键
        public K key;
        //存储值
        public V value;
        //记录左子节点
        public Node left;
        //记录右子节点
        public Node right;
        //记录颜色
        public boolean color;
        //构造方法
        private Node(K key, V value, Node left, Node right, boolean color){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    /**
     * 判断当前节点的父节点的指向链接是否为红色
     * @param node 要判断的节点
     * @return 判断结果
     */
    private boolean isRed(Node node){
        //空结点默认是黑色链接
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    /**
     * 获取树上元素个数
     * @return 元素个数
     */
    public int size(){
        return N;
    }

    /**
     * 向整棵树上插入元素
     * @param key 键
     * @param value 值
     */
    public void put(K key, V value){
        //创建树
        root = put(root, key, value);
        //修改链接颜色
        root.color = BLACK;
    }

    /**
     * 向指定节点插入元素
     * @param node 指定的节点
     * @param key 键
     * @param value 值
     * @return 返回的节点
     */
    private Node put(Node node, K key, V value) {
        //递归终点，前面和普通完全二叉树过程一致
        if (node == null){
            N++;
            return new Node(key, value, null, null, RED);
        }
        int cmpResult = key.compareTo(node.key);
        //判断要插入的键和当前节点的关系
        if (cmpResult > 0){
            //要插入的节点键大于当前节点的键
            node.right = put(node.right, key, value);
        }else if (cmpResult < 0){
            //要插入的节点键小于当前节点的键
            node.left = put(node.left, key, value);
        }else {
            node.value = value;
        }

        //当前节点左子树链接是黑色，右子树节点链接是红色，要求左旋
        if (isRed(node.right) && !isRed(node.left)){
            node = rotateLeft(node);
        }
        if (node.left != null){
            //当前节点的左子树的左子树链接和左子树节点链接都是红色，要求右旋
//            if (isRed(node.left) && isRed(node.left.right)){
//                node.left = rotateLeft(node.left);
//                node = rotateRight(node);
//            }
            //当前节点的左子树的左子树链接和左子树节点链接都是红色，要求右旋
            if (isRed(node.left) && isRed(node.left.left)){
                node = rotateRight(node);
            }
        }
        //左右子树节点都为红色，颜色反转
        if (isRed(node.left) && isRed(node.right)){
            colorReverse(node);
        }
        return node;
    }
    /*
    此处将颜色反转和左旋调换位置亦可以
        //左右子树节点都为红色，颜色反转
        if (isRed(node.left) && isRed(node.right)){
            colorReverse(node);
        }

        //当前节点链接是黑色右子树节点链接是红色，要求左旋
        if (!isRed(node) && isRed(node.right)){
            node = rotateLeft(node);
        }
         */

    /**
     * 将当前节点本身以及左右子树链接颜色反转
     * @param node 当前节点
     */
    private void colorReverse(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 将当前节点进行左旋
     * @param node 要左旋的节点
     * @return 要返回的节点
     */
    private Node rotateLeft(Node node) {
        //获取当前节点的右子树
        Node right = node.right;
        //给当前节点的右子树赋值
        node.right = right.left;
        //给当前节点的右子树的左子树赋值
        right.left = node;
        //让当前结点的color值成为右子结点的color值
        right.color = node.color;
        //让当前结点的color变为RED
        node.color = RED;
        //返回数据
        return right;
    }

    /**
     * 将当前节点进行右旋
     * @param node 要右旋的节点
     * @return 要返回的节点
     */
    private Node rotateRight(Node node) {
        //获取当前节点的左子树
        Node left = node.left;
        //将当前节点的左子树的右子树设置为当前节点的左子树
        node.left = left.right;
        //将当前节点的左子树的右子树设置为当前节点
        left.right = node;
        //让当前结点的color值称为左子结点的color值
        left.color = node.color;
        //让当前结点的color变为RED
        node.color = RED;
        //返回节点
        return left;
    }

    /**
     * 从整棵树通过键获取值
     * @param key 键
     * @return 值
     */
    public V get(K key){
        return get(root, key);
    }

    /**
     * 从指定节点通过键获取值
     * @param key 键
     * @return 值
     */
    private V get(Node node, K key) {
        //递归的终点
        if (node == null){
            return null;
        }
        //定义比较结果
        int cmpResult = key.compareTo(node.key);
        if (cmpResult > 0){
            //将当前节点用右子树代替
            return get(node.right, key);
        }else if (cmpResult < 0){
            //将当前节点用左子树代替
            return get(node.left, key);
        }else{
            return node.value;
        }
    }



}
