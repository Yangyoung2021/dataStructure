package dateSource.linear;

import itHeima.linear.LinkList;
import org.junit.jupiter.api.Test;

public class TestLinkList {

    @Test
    public void testList(){
        LinkList<String> list = new LinkList<>();

        list.insert("kobe");
        list.insert("詹姆斯");
        list.insert("姚明");
        list.insert("麦迪");
        list.insert("猪八戒");
        System.out.println("反转前的链表：");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------");
        System.out.println("反转后的链表：");
        list.reverse();
        for (String s : list) {
            System.out.println(s);
        }

//        System.out.println(list.get(1));
//        System.out.println(list.length());
//        System.out.println(list.isEmpty());
//
//        list.insert(2,"尼克杨");
//
//        String remove = list.remove(1);
//        System.out.println(remove);
//
//        System.out.println(list.indexOf("姚明"));
//
//        System.out.println("-----------------");
//        for (String s : list) {
//            System.out.println(s);
//        }

    }
}
