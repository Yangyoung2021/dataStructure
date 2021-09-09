package dateSource.linear;

import itHeima.linear.TwoWayLinkList;
import org.junit.jupiter.api.Test;

public class TestTwoWayLinkList {

    @Test
    public void testList(){
        TwoWayLinkList<String> list = new TwoWayLinkList<>();

        list.insert("kobe");
        list.insert("詹姆斯");
        list.insert("姚明");
        list.insert("麦迪");
        list.insert("猪八戒");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-----------");
        System.out.println("第一个值为："+list.getFirst());
        System.out.println("索引为一的值为："+list.get(1));
        System.out.println("链表长度为："+list.length());
        System.out.println("链表是否为空："+list.isEmpty());
        System.out.println("链表最后一个值为："+list.getLast());

        list.insert(2,"尼克杨");
        System.out.println("插入尼克杨作为索引2后的数据变成了：");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("---------------------------");
        String remove = list.remove(1);
        System.out.println("删除的索引为1的值为："+remove);

        System.out.println("姚明所在地索引为："+list.indexOf("姚明"));

        list.insert(4,"张三");

        list.insert(0,"猪八戒");

        System.out.println("-----------------");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(list.length());

        System.out.println("------------------");


    }
}
