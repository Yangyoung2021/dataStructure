package itHeima.graph;

import itHeima.linear.Queue;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {
    //顶点个数
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private final Queue<Edge>[] adj;

    /**
     * 构造方法
     * @param V 初始化边数
     */
    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }
    }

    /**
     * 获取顶点数目
     * @return 顶点数目
     */
    public int V(){
        return V;
    }

    /**
     * 获取边的数目
     * @return 边数
     */
    public int E(){
        return E;
    }

    /**
     * 向图中添加一条边
     * @param e 要添加的边
     */
    public void addEdge(Edge e){
        //无向图中边是没有方向的，要使用双向的，获取边的两个顶点
        int v = e.one();
        int w = e.theOther(v);

        //将该边添加到两个顶点的队列中
        adj(v).enqueue(e);
        adj(w).enqueue(e);

        //边的数目加一
        E++;
    }

    /**
     * 获取索引为v处的所有边
     * @param v 索引
     * @return 邻接表
     */
    public Queue<Edge> adj(int v){
        return adj[v];
    }

    /**
     * 获取当前加权树的所有边
     * @return 包含所有边的栈
     */
    public Queue<Edge> edges(){
        //创建一个返回数据的栈
        Queue<Edge> edges = new Queue<>();
        //遍历当前图的邻接表
        for (int v = 0; v < V; v++) {
            //遍历当前栈
            for (Edge e : adj(v)) {
                //判断当前边的顶点和另一个顶点的大小，添加小的顶点到栈中
                if (e.theOther(v) < v){
                    edges.enqueue(e);
                }
            }
        }
        return edges;
    }
}
