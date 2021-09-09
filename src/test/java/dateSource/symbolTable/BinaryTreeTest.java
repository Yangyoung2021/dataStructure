package dateSource.symbolTable;

import itHeima.linear.Queue;
import itHeima.tree.BinaryTree;

public class BinaryTreeTest {
    //测试代码
    public static void main(String[] args){
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.preNotErgodic();
        bt.put("E", "二哈");
        bt.put("B", "张三");
        bt.put("G", "王德发");
        bt.put("A", "李四");
        bt.put("D", "王五");
        bt.put("C","牛阿姨");
        bt.put("G","老王");
        bt.put("F","老王");
        bt.put("H","老王");
        System.out.println("总节点个数："+bt.size());
//        bt.put(1,"老三");
//        System.out.println("替换后的一号："+bt.get(1));
        System.out.println("替换后的节点数："+bt.size());
//        bt.remove(3);
//        System.out.println("删除后的节点数："+bt.size());
        System.out.println("-------------");
        System.out.println("(牛阿姨)最大值是：" + bt.getMax());
        System.out.println("(老三)最小值是：" + bt.getMin());
        System.out.println("--------------");


        System.out.println("前序遍历结果：");
        Queue<String> integer = bt.preNotErgodic();
//        Queue<Integer> integer = bt.preErgodic();
        for (String i : integer) {
            System.out.print(i+" , ");
        }
        System.out.println();
        System.out.println("中序遍历结果：");
        Queue<String> queue = bt.midErgodic();
        for (String i : queue) {
            System.out.print(i+" , ");
        }
        System.out.println();
        System.out.println("后序遍历结果：");
        Queue<String> queue1 = bt.afterErgodic();
        for (String i : queue1) {
            System.out.print(i+" , ");
        }

        System.out.println();
        System.out.println("层序遍历结果：");
        Queue<String> layer = bt.layerErgodic();
        for (String i : layer) {
            System.out.print(i+" , ");
        }

        System.out.println(bt.maxDepth());



    }

}
