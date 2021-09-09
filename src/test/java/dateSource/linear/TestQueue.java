package dateSource.linear;

import itHeima.linear.Queue;
import org.junit.jupiter.api.Test;

/**
 * 测试队列的方法
 */
public class TestQueue {

    @Test
    public void test(){
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println("---------------");

        String dequeue = queue.dequeue();
        System.out.println("出队列的元素是：" +dequeue);
        System.out.println(queue.length());
    }

}
