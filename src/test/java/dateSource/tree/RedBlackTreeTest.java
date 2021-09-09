package dateSource.tree;

import itHeima.tree.RedBlackTree;

public class RedBlackTreeTest {
    public static void main(String[] args) throws Exception {
        RedBlackTree<Integer, String> bt = new RedBlackTree<>();
        bt.put(1, "二哈");
        bt.put(2, "张三");
        bt.put(3, "李四");
        bt.put(4, "王五");
        bt.put(5, "该刘子");
        bt.put(6, "赵六");
        bt.put(7, "令其");
        bt.put(8, "王八蛋");
        bt.put(9,"小豆豆");
        bt.put(12,"小豆豆");
        bt.put(10,"小豆豆");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
    }
}
