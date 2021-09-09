package itHeima.tree;

import itHeima.linear.Queue;
import itHeima.linear.Stack;

/**
 * 二叉树，做多只能有两个节点
 */
public class BinaryTree<K extends Comparable<K>, V> {

    //记录根节点
    private Node root;
    //记录元素个数
    private int N;

    //私有内部类
    private class Node{
        //存储键
        public K key;
        //存储值
        public V value;
        //存储左节点
        public Node left;
        //存储右节点
        public Node right;

        public Node(K key, V value, Node left, Node right){
            this.key = key;
            this.value = value;
            this.right = right;
            this.left = left;
        }
    }

    //获取树中元素个数
    public int size(){
        return N;
    }

    //向树中添加元素key-value
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    //真正执行插入的方法
    private Node put(Node node, K key, V value) {
        //如果子树为空，直接返回新建的空节点，也是递归的终点
        if (node == null){
            N++;
            return new Node(key, value, null, null);
        }
        int cmpResult = key.compareTo(node.key);
        //如果不为空，判断根节点与新建的节点的key大小来将决定该节点放入左侧还是右侧
        if (cmpResult > 0){
            //放到右侧
            node.right = put(node.right, key, value);
        }else if (cmpResult < 0){
            //放到左侧
            node.left = put(node.left, key, value);
        }else{
            //将原来的节点的值替换
            node.value = value;
        }
        return node;
    }

    //根据键获取值
    public V get(K key){
        return get(root, key);
    }

    //根据键获取值
    public V get(Node node, K key){
        //递归终点
        if (node == null){
            return null;
        }

        int cmpResult = key.compareTo(node.key);
        //判断比较结果
        if (cmpResult > 0){
            return get(node.right, key);
        }else if (cmpResult < 0){
            return get(node.left, key);
        }else{
            return node.value;
        }
    }

    //删除指定节点
    public void remove(K key){
        remove(root, key);
    }

    //真正执行删除的方法
    private Node remove(Node node, K key) {
        if (node == null){
            //不存在该节点
            return null;
        }

        int cmpResult = key.compareTo(node.key);
        //左节点为空就返回右节点
        if (cmpResult < 0){
            node.left =  remove(node.left, key);
        }else if (cmpResult > 0){
            node.right =  remove(node.right, key);
        }else {
            N--;
            //node就是要删除的节点
            if (node.left == null){
                return node.right;
            }
            if (node.right == null){
                return node.left;
            }
            //左右子树都不为空
            Node right = node.right;
            Node left = node.left;
            Node rightResult = right;
            Node leftResult = left;
            int leftNum = 1;
            int rightNum = 1;

            //获取左侧层级最大值
            while(left.right != null || left.left != null){
                if (left.right != null){
                    left = left.right;
                }else{
                    left = left.left;
                }
                leftNum++;
            }
            //获取右侧层级最小值
            while(right.left != null || right.right != null){
                if (right.left != null){
                    right = right.left;
                }else{
                    right = right.right;
                }
                rightNum++;
            }
            //将层级大的那一侧的最后一个节点作为新的代替节点
            if (leftNum > rightNum){
                //左侧层级大于右侧层级
                while(leftResult.right != null){
                    if (leftResult.right.right == null){
                        leftResult.right = null;
                    }else{
                        leftResult = leftResult.right;
                    }
                }
//                node.left = leftResult.left;
                leftResult.right = node.right;
                node = leftResult;
            }else{
                //右侧层级大于等于左侧层级
                while(rightResult.left != null){
                    if (rightResult.left.left == null){
                        rightResult.left = null;
                    }else{
                        rightResult = rightResult.left;
                    }
                }
//                node.right = rightResult.right;
                rightResult.left = node.left;
                node = rightResult;
            }
        }
        return node;
    }

    //查找最小键
    public V getMin(){
        return getMin(root);
    }

    private V getMin(Node node) {
        if (node.left == null) return node.value;
        return getMin(node.left);
    }

    //查找整棵树最大键
    public V getMax(){
        return getMax(root);
    }
    //查找根节点为node的树的最大键
    private V getMax(Node node) {
        if (node.right == null) return node.value;
        return getMax(node.right);
    }

    //前序递归遍历整棵树
    public Queue<K> preErgodic(){
        Queue<K> queue = new Queue<>();
        preErgodic(root, queue);
//        preNotErgodic(root ,queue);
        return queue;
    }
    //前序遍历递归方法
    private void preErgodic(Node node, Queue<K> queue) {
        if (node == null){
            return;
        }
        //先将头结点放入队列
        queue.enqueue(node.key);
        //放入左分支
        if (node.left != null){
            preErgodic(node.left, queue);
        }
        //放入右分支
        if (node.right != null){
            preErgodic(node.right, queue);
        }
    }

    //前序非递归遍历整棵树
    public Queue<K> preNotErgodic(){
        Queue<K> queue = new Queue<>();
        preNotErgodic(root ,queue);
//        notPreErgodic(root,queue);
        return queue;
    }

    //前序遍历非递归方法
    public void preNotErgodic(Node node, Queue<K> queue){
        /*
        利用栈进行遍历，先将根节点放入栈中，然后判断是否有左子树，如果有就保存右子树，直到没有左子树为止
        ，开始遍历右子树
         */
        if (node == null) return;
        //建立一个栈用来保存前一个节点
        Stack<Node> stack = new Stack<>();
        //遍历直到栈为空与节点同时为空为止
        while(!stack.isEmpty() || node != null){
            while(node != null){
                //前序遍历： 当一个节点不为空的时候，第一件事就是将这个节点的key放入队列中去
                //然后在将遍历到下一个节点
                queue.enqueue(node.key);
                stack.push(node);
                node = node.left;
            }
            //出来以后说明左子树为空了，接下来就应该拿出前一个节点
            node = stack.pop();
            //遍历前一个节点的右分支，若此时右分支为空且栈内节点也为空就退出循环
            node = node.right;
        }
    }

    //前序非递归遍历方法2（仅仅适用于前序遍历）
    public void notPreErgodic(Node node, Queue<K> queue){
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        //直接将根节点放入栈中
        stack.push(node);
        //遍历直到栈为空为止
        while(!stack.isEmpty()){
            node = stack.pop();
            queue.enqueue(node.key);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    //中序遍历整棵树
    public Queue<K> midErgodic(){
        Queue<K> queue = new Queue<>();
        midErgodic(root, queue);
        return queue;
    }
    //中序遍历递归方法
    private void midErgodic(Node node, Queue<K> queue) {
        if (node == null){
            return;
        }
        //放入左分支
        if (node.left != null){
            midErgodic(node.left, queue);
        }
        //放入根节点
        queue.enqueue(node.key);
        //放入右分支
        if (node.right != null){
            midErgodic(node.right, queue);
        }
    }

    //中序遍历非递归方法
    public void midNotErgodic(Node node, Queue<K> queue){
        /*
        利用双指针方法进行遍历
         */
    }

    //后序遍历整棵树
    public Queue<K> afterErgodic(){
        Queue<K> queue = new Queue<>();
        afterErgodic(root, queue);
        return queue;
    }
    //后序遍历递归方法
    private void afterErgodic(Node node, Queue<K> queue) {
        if (node == null){
            return;
        }
        //放入左分支
        if (node.left != null){
            afterErgodic(node.left, queue);
        }

        //放入右分支
        if (node.right != null){
            afterErgodic(node.right, queue);
        }

        //放入根节点
        queue.enqueue(node.key);
    }

    //层序遍历
    public Queue<K> layerErgodic(){
        if (root == null){
            return null;
        }
        Queue<K> queue = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while(!nodes.isEmpty()){
            //将队列中的第一个元素取出
            Node x = nodes.dequeue();
            //将他的key放入返回队列
            queue.enqueue(x.key);
            //判断该元素的左子树是否为空
            if (x.left != null){
                //不为空就将他加入到这个队列中用于下次取出
                nodes.enqueue(x.left);
            }
            //判断该元素的右子树是否为空
            if (x.right != null){
                //不为空就将他加入到这个队列中用于下次取出
                nodes.enqueue(x.right);
            }
        }
        return queue;
    }

    //获取整棵树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }

    /*
    逻辑分析（递归调用）：
        每次调用子节点去调用他们的字节点并返回他们子节点的个数
     */
    //获取当前传入节点作为根节点的最大深度
    public int maxDepth(Node node){
        if (node == null){
            return 0;
        }
        int maxDep;
        int maxRight = 0;
        int maxLeft = 0;
        if (node.left != null){
            maxLeft = maxDepth(node.left);
        }
        //node.left == null此时
        if (node.right != null){
            maxRight = maxDepth(node.right);
        }
        //此时node左右子树都为空
        maxDep = maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;
        //返回子树加当前节点的深度
        return maxDep;
    }
}
