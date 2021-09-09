package dateSource.linear;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TestLinkedList {


    @Test
    public void testList(){
        LinkedList<String> list = new LinkedList<>();

        list.add("kobe");
        list.add("詹姆斯");
        list.add("姚明");
        list.add("麦迪");

        System.out.println(list.get(1));
        System.out.println(list.size());

        list.add(1,"尼克杨");

        System.out.println("-----------------");
        for (String s : list) {
            System.out.println(s);
        }



    }




}
