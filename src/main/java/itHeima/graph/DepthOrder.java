package itHeima.graph;

import itHeima.linear.Stack;

public class DepthOrder {
    //代表是否已经标记过
    private final boolean[] marked;
    //反转后的栈，存储顶点的序列
    private final Stack<Integer> reversePost;

    /**
     * 初始化方法
     * @param graph 要初始化的有向图
     */
    public DepthOrder(DirectedGraph graph){
        //初始化标记数组
        this.marked = new boolean[graph.V()];
        //初始化反转栈
        this.reversePost = new Stack<Integer>();

        //遍历每个顶点
        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]){
                dfs(graph, v);
            }
        }
    }

    /**
     * 基于深度优先检测图中是否有环
     * @param graph 要反转的图
     * @param v 反转起点
     */
    private void dfs(DirectedGraph graph, int v) {
        //将当前的点标记为已搜索
        marked[v] = true;
        //从邻接表中获取索引为v的队列并进行遍历
        for (Integer w : graph.adj(v)) {
            //判断当前的索引是否有出度
            if (!marked[w]){
                //有出度，递归到没有出度为止
                dfs(graph, w);
            }
        }
        //将当前顶点入栈
        reversePost.push(v);
    }

    /**
     * 获取反转图的栈
     * @return 图的反转栈
     */
    public Stack<Integer> ReversePost(){
        return reversePost;
    }
}
