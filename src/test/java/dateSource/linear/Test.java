package dateSource.linear;



//测试类
public class Test {
    public static void main(String[] args){
        Node<String> one = new Node<>("aa", null);//起点
        Node<String> one1 = new Node<>("aa", null);//起点
        Node<String> one2 = new Node<>("aa", null);//起点
        Node<String> one3 = new Node<>("aa", null);//起点
        Node<String> one4 = new Node<>("aa", null);//起点
        Node<String> one5 = new Node<>("aa", null);//起点
        Node<String> one6 = new Node<>("aa", null);//起点
        Node<String> one7 = new Node<>("aa", null);//起点
        Node<String> one8 = new Node<>("aa", null);//起点
        Node<String> one9 = new Node<>("aa", null);//起点
        Node<String> two = new Node<>("bb", null);
        Node<String> three = new Node<>("cc", null);//1.快
        Node<String> four = new Node<>("dd", null);
        Node<String> five = new Node<>("ee", null);//2.快
        Node<String> six = new Node<>("ff", null);
        Node<String> seven = new Node<>("gg", null);//3.快
        Node<String> eight = new Node<>("hh", null);
        Node<String> nine = new Node<>("ii", null);//4.快
        //完成结点之间的指向
        one.next = one1;
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        one4.next = one5;
        one5.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = six;
        //查找中间值
        String mid = getMid(one);
        System.out.println("中间值为："+mid);
        boolean flag = circle(one);
        System.out.println("链表是否有环：" +flag);
        Node<String> stringNode = circleEntrance(one);
        System.out.println("环节点为："+stringNode.item);
    }
    /**
     * @param first 链表的首结点
     * @return 链表的中间结点的值
     */
    public static String getMid(Node<String> first) {
        //定义两个指针
        Node<String> fast = first;
        Node<String> slow = first;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    public static boolean circle(Node<String> first) {
        //定义两个指针
        Node<String> fast = first;
        Node<String> slow = first;
        while(fast != null && fast.next != null){
            fast = fast.next.next.next.next.next.next;
            slow = slow.next;
            if (fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    public static Node<String> circleEntrance(Node<String> first) {
        //定义两个指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next.next.next.next.next;
            slow = slow.next;

            if (fast.equals(slow) && temp == null){
                temp = first;
                continue;
            }

            if (temp != null){
                temp = temp.next;
                if (temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
    }
    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node<T> next;
        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
