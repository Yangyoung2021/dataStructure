package dateSource.symbolTable;

import itHeima.heap.Heap;
import org.junit.jupiter.api.Test;


public class HeapTest {

    @Test
    public void test(){
        Heap<String> heap = new Heap<>(20);
        heap.insert("A");
        heap.insert("G");
        heap.insert("F");
        heap.insert("E");
        heap.insert("D");
        heap.insert("C");
        heap.insert("B");

        String result;
        while((result = heap.delMax()) != null){
            System.out.println(result + " ,");
        }
/*        Heap<Integer> heaps = new Heap<>(20);
        heaps.insert(31);
        heaps.insert(110);
        heaps.insert(20);
        heaps.insert(142);
        heaps.insert(12);
        heaps.insert(15);
        heaps.insert(1);
        heaps.insert(4);
        heaps.insert(2);
        heaps.insert(52);
        heaps.insert(28);
        heaps.insert(10);
        for (Integer heap : heaps) {

            Integer integer = heaps.delMax();
            System.out.println(heap);
            System.out.println(integer + " , ");
        }
        System.out.println("------------");

        Integer result;
        while((result = heaps.delMax()) != null){
            System.out.println(result + " ,");
        }

        System.out.println("-------------");*/


    }
}
