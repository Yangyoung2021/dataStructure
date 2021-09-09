package dateSource.priorityQueue;

import itHeima.priorityQueue.IndexMinPriorityQueue;

public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        IndexMinPriorityQueue<String> indexMinPQ = new IndexMinPriorityQueue<>(20);
        //插入
        for (int i = 0; i < arr.length; i++) {
            indexMinPQ.insert(i,arr[i]);
        }
        System.out.println(indexMinPQ.size());
        //获取最小值的索引
        System.out.println(indexMinPQ.minIndex());
        //测试修改
        indexMinPQ.update(0,"Z");

        System.out.println("删除的最小元素是："+indexMinPQ.delMin());

        System.out.println("查询到的元素是："+indexMinPQ.minIndex());

        int minIndex;
        while(!indexMinPQ.isEmpty()){
            minIndex = indexMinPQ.delMin();
            System.out.print(minIndex+"==>" );
        }
        System.out.println();
    }
}
