package itHeima.graph;

public class DepthFirstCircle {
    //索引代表顶点，值代表是否被搜索
    private final boolean[] marked;
    //代表是否有循环
    private boolean hasCircle;
    //索引代表顶点，使用栈的思想，记录当前顶点是否处于正在搜索的路径上
    private final boolean[] onStack;

    public DepthFirstCircle(DirectedGraph graph){
        //初始化数组marked
        this.marked = new boolean[graph.V()];
        //初始化hasCircle
        this.hasCircle = false;
        //初始化onStack数组
        this.onStack = new boolean[graph.V()];

        //遍历每个顶点用来判断是否存在环
        for (int v = 0; v < graph.V(); v++) {
            dfs(graph, v);
        }
    }

    /**
     * 搜索方法
     * @param graph 要搜索的图
     * @param v 要搜索的顶点
     */
    private void dfs(DirectedGraph graph, int v) {
        //将当前顶点标记为已搜索
        marked[v] = true;
        //先将当前顶点标记为已搜索
        onStack[v] = true;
        for (Integer W : graph.adj(v)) {
            if (!marked[W]){
                dfs(graph, W);
            }
            //如果不存在环，当前的所有除了W以外都是true，但是W作为最后一个没有出度的顶点还没有被改变onStack的值，false被传递下去
            //如果当前图存在环，它的onStack还没有被修改为false，所以会得到true，然后一直传递下去
            if (onStack[W]){
                hasCircle = true;
                return;
            }
        }
        //当前顶点出栈，让当前顶点回复为未搜索
        onStack[v] = false;
    }

    /**
     * 判断当前顶点是否被搜索了
     * @return 判断结果
     */
    public boolean hasCircle(){
        return this.hasCircle;
    }
}
