package itHeima.graph;

public class DepthFirst {
    //索引代表顶点，值代表是否被搜索
    private final boolean[] marked;
    //代表与s相遇的顶点个数
    private int count;

    public DepthFirst(Graph graph, int s){
        //初始化数组marked
        this.marked = new boolean[graph.V()];
        //初始化count
        this.count = 0;

        dfs(graph, s);
    }

    /**
     * 搜索方法
     * @param graph 要搜索的图
     * @param s 要搜索的顶点
     */
    private void dfs(Graph graph, int s) {
        marked[s] = true;
        for (Integer W : graph.adj(s)) {
            if (!marked[W]){
                dfs(graph, W);
            }
        }
        //连通数量加一
        count++;
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
