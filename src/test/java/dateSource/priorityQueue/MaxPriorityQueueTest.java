package dateSource.priorityQueue;


import itHeima.priorityQueue.MaxPriorityQueue;

class MaxPriorityQueueTest {
    public static void main(String[] args) {
        //创建最大优先队列对象
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);

        //添加元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        while(!queue.isEmpty()){
            System.out.print(queue.removeMax() + " ");
        }
    }
}
