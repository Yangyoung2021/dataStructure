package dateSource.tree;

import itHeima.linear.Queue;
import itHeima.tree.BinaryTree;

public class TestBinaryTree {

    public static void main(String[] args) {
        BinaryTree<Integer, Integer> binaryTree = new BinaryTree<>();
        binaryTree.put(10,10);
        binaryTree.put(7,10);
        binaryTree.put(6,10);
        binaryTree.put(8,10);
        binaryTree.put(5,10);
        binaryTree.put(12,10);
        binaryTree.put(11,10);
//        System.out.println("0--------------");
//        System.out.println(binaryTree.maxDepth());
        Queue<Integer> elements = binaryTree.midErgodic();
        for (Integer element : elements) {
            System.out.print(element+ " ");
        }
        System.out.println();
        binaryTree.remove(7);
        Queue<Integer> queue = binaryTree.midErgodic();
        for (Integer integer : queue) {
            System.out.print(integer+" ");
        }
//        System.out.println("0--------------");
//        System.out.println(binaryTree.maxDepth());
    }
}
