package dateSource.linear;

import itHeima.linear.SequenceList;
import org.junit.jupiter.api.Test;


public class TestSequenceList {

    @Test
    public void test(){
        SequenceList<String> sequenceList = new SequenceList<>(5);

        sequenceList.insert("易小川");
        sequenceList.insert("高要");
        sequenceList.insert("蒙恬");
        sequenceList.insert("素素");
        sequenceList.insert("玉漱公主");
        sequenceList.insert("蒙毅",2);

        System.out.println("迭代器打印结果：");
        System.out.println();
        for (String s : sequenceList) {
            System.out.println(s);
        }


    }


}
