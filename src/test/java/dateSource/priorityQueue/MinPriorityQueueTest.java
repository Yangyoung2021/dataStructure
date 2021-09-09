package dateSource.priorityQueue;


import itHeima.priorityQueue.MinPriorityQueue;

class MinPriorityQueueTest {
    public static void main(String[] args) {
        //创建最大优先队列对象
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);

        //添加元素
        queue.insert("G");
        queue.insert("F");
        queue.insert("E");
        queue.insert("D");
        queue.insert("C");
        queue.insert("B");
        queue.insert("A");

        while(!queue.isEmpty()){
            System.out.print(queue.removeMin() + " ");
        }
    }
}
