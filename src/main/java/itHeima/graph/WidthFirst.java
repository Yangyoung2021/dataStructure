package itHeima.graph;

import itHeima.linear.Queue;

public class WidthFirst {
    //索引代表顶点，值代表是否被搜索
    private final boolean[] marked;
    //代表与s相遇的顶点个数
    private int count;
    //用于辅助的队列
    private final Queue<Integer> Q;

    public WidthFirst(Graph graph, int s){
        //初始化数组marked
        this.marked = new boolean[graph.V()];
        //初始化count
        this.count = 0;
        //初始化队列
        this.Q = new Queue<>();

        wfs(graph, s);
    }

    /**
     * 搜索方法
     * @param graph 要搜索的图
     * @param s 要搜索的顶点
     */
    private void wfs(Graph graph, int s) {
        marked[s] = true;
        count++;
        Q.enqueue(s);
        while(!Q.isEmpty()){
            Integer dequeue = Q.dequeue();
            //先将兄弟顶点放进队列
            for (Integer W : graph.adj(dequeue)) {
                //判断是否已经连接
                if (!marked(W)){
                    marked[W] = true;
                    Q.enqueue(W);
                    //连通数量加一
                    count++;
                }
            }
        }
    }

    /**
     * 判断当前顶点是否被搜索了
     * @param w 要判断的顶点
     * @return 判断结果
     */
    public boolean marked(int w){
        return this.marked[w];
    }

    /**
     * 获取当前顶点的连接数
     * @return 连接数
     */
    public int count(){
        return count;
    }
}
