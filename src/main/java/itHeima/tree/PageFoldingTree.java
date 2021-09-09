package itHeima.tree;

import itHeima.linear.Queue;

/**
 * 折纸树问题
 */
public class PageFoldingTree {
    private final static String DOWN = "down";
    private final static String UP = "up";
    public static void main(String[] args) {
        int times = 4 ;
        //调用创建树的方法
        Node<String> root = createTree(times);
        //调用执行遍历树的方法
        printTree(root);
//        System.out.println();
    }

    //使用中序遍历树
    private static void printTree(Node<String> root) {
        if (root == null){
            return;
        }
        if (root.left != null) printTree(root.left);
        System.out.print(root.item+ "  ");
        if (root.right != null) printTree(root.right);
    }

    //创建折纸树的方法
    private static Node<String> createTree(int N) {
        //定义根节点
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            if (i == 0){
                //第一次折纸一定是朝下的
                root = new Node<>(DOWN, null, null);
            }else{
                //创建队列来进行层序遍历
                Queue<Node<String>> queue = new Queue<>();
                //存入根节点
                queue.enqueue(root);
                //遍历到队列中为空为止
                while(!queue.isEmpty()){
                    //从队列拿出顺序放入的数据
                    Node<String> temp = queue.dequeue();
                    //此处由于每次都是直接对折，所以左节点和右节点是一样的，只拿左节点作为判断
                    if (temp.left != null){
                        //由于是直接对折的，所以有左节点就一定有右节点
                        queue.enqueue(temp.left);
                        queue.enqueue(temp.right);
                    }else{
                        //如果遍历还没有完成，而且要求的节点还是为空就直接创建新的节点
                        temp.left = new Node<String>(DOWN, null, null);
                        temp.right = new Node<String>(UP, null, null);
                    }
                }
            }
        }
        return root;
    }

    //静态内部类
    private static class Node<T>{
        public T item;
        public Node<String> right;
        public Node<String> left;
        public Node(T item, Node<String> right, Node<String> left){
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    public static Node<String> createsTree(int N){
        Node<String> root = null;
        //设置循环次数
        for (int i = 0; i < N; i++) {
            if (i == 0){
                //第一次折纸，将朝向设置为向下
                root = new Node<>(DOWN, null, null);
            }else{
                //不是第一次折纸，使用层序遍历来创建折纸过程
                //创建一个队列来保存顺序
                Queue<Node<String>> queue = new Queue<>();
                queue.enqueue(root);
                //当队列中有数据时就进行操作
                while(!queue.isEmpty()){
                    //获取当前要操作的节点
                    Node<String> curr = queue.dequeue();
                    //全是对折过程所以左子树和右子树是一样的，此处只拿右子树作为判断依据
                    if (curr.right != null){
                        //将其子树添加到队列
                        queue.enqueue(curr.right);
                        queue.enqueue(curr.left);
                    }else{
                        curr.left = new Node<>(DOWN, null, null);
                        curr.right = new Node<>(UP, null, null);
                    }
                }
            }
        }
        return root;
    }
    
}
