package dateSource.linear;

/**
 * 关于约瑟夫循环链表的解决方案
 */
public class JosephTest {
    /*
    约瑟夫循环链表逻辑分析：
        1.构建循环链表
        2.模拟循环链表的报数过程
        3.打印退出循环的编号
     */

    public static void main(String[] args){
        killSelf();
    }

    public static void killSelf(){
        //定义两个指针
        Node<Integer> first = null;
        Node<Integer> prev = null;
        for (int i = 1; i <= 10; i++) {
            /*
            分析成三种情况：
                1.当前是第一次创建节点
                2.当前既不是第一次也不是最后一次创建节点
                3.当前是最后一次创建节点
             */
            //第一次创建，将prev初始化
            if (i == 1){
                first = new Node<>(i, null);
                prev = first;
            }
            //普通情况
            if (i > 1){
                Node<Integer> newNode = new Node<>(i, null);
                //将前一个节点的下一个节点设置为当前节点
                prev.next = newNode;
                //将当前节点设置为前一个节点
                prev = newNode;
            }
            if (i == 10){
                prev.next = first;
            }
        }

        //模拟自杀过程
        /*
        启动循环，结束条件为
        设置一个count变量用来记录报数的值，每当count对3取余的结果为零就退出链表，count重新计数
        打印退出的人的item
         */
        int count = 0;
        //记录当前节点
        Node<Integer> curr = first;
        //记录当前节点的上一个节点
        Node<Integer> before = null;
        //记录自杀总人数
        int m = 0;
        //当当前节点的上一个节点和下一个节点相等时就结束（证明只剩下了两个人）
        while(!curr.next.equals(before)){
            //报数加一
            count++;
            //判断当前节点是不是3的倍数
            if (count%3 == 0){
                //是3的倍数，当前节点自杀，退出循环，count归零
                count = 0;
                if (m%25 == 0){
                    System.out.println();
                }
                //打印退出节点的item
                System.out.print(curr.item + ", ");
                //将前一个节点直接指向当前节点的下一个节点
                before.next = curr.next;
                //死亡人数加一
                m++;
            }
            //将当前节点设置为上一个节点
            before = curr;
            //将下一个节点设置为当前节点
            curr = curr.next;
        }
        System.out.println();
        System.out.println("总的自杀人数为："+m);
        System.out.println("最终存活的人是：" + curr.item + " " +curr.next.item);
    }

    //创建节点内部类
    static class Node<T>{
        private Node next;
        private final T item;
        private Node(T item, Node<T> next){
            this.next = next;
            this.item = item;
        }
    }
}
