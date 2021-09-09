package itHeima.graph;

import itHeima.linear.Stack;

public class DepthFirstPaths {
    //索引代表顶点，值代表是否被搜索
    private final boolean[] marked;
    //代表起点
    private final int s;
    //索引代表顶点，值代表从起点到终点的前一个顶点
    private final int[] edgeTo;

    /**
     * 初始换方法
     * @param graph 要进行搜索的图
     * @param s 起点
     */
    public DepthFirstPaths(Graph graph, int s){
        //初始化数组marked
        this.marked = new boolean[graph.V()];
        //初始化起点
        this.s = s;
        //初始化edgeTo数组
        this.edgeTo = new int[graph.V()];

        dfs(graph, s);
    }

    /**
     * 搜索方法
     * @param graph 要搜索的图
     * @param v 要搜索的顶点
     */
    private void dfs(Graph graph, int v) {
        //将起点标记为已搜索
        marked[v] = true;
        //遍历索引为s的邻接表
        for (Integer W : graph.adj(v)) {
            //W代表该邻接表中的数据
            if (!marked[W]){
                //将数组edgeTo索引为w处的值设置为s
                edgeTo[W] = v;
                //递归调用搜索方法
                dfs(graph, W);
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
        return s;
    }

    /**
     * 找到从起点到顶点的路径
     * @param v 要找的顶点
     * @return 保存路径的栈
     */
    public Stack<Integer> pathTo(int v){
        if (!marked(v)) return null;
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while(edgeTo[v] != 0){
            stack.push(edgeTo[v]);
            v = edgeTo[v];
        }
        stack.push(s);
        return stack;
    }
}
