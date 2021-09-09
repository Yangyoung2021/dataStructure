package itHeima.graph;

import itHeima.linear.Queue;

/**
 * 无向图
 */
public class Graph {
    //顶点个数
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private final Queue<Integer>[] adj;

    /**
     * 构造方法
     * @param V 初始化边数
     */
    public Graph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
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
     * @param v 要添加到的邻接表
     * @param w 要添加的数据
     */
    public void addEdge(int v, int w){
        //无向图中边是没有方向的，要使用双向的
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    /**
     * 获取索引为v处的邻接表
     * @param v 索引
     * @return 邻接表
     */
    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
