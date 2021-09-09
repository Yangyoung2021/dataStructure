package itHeima.graph;

import com.sun.istack.internal.NotNull;

/**
 * 加权边
 */
public class Edge implements Comparable<Edge> {
    //一个顶点
    private final int v;
    //另一个顶点
    private final int w;
    //当前边的权重
    private final double weight;

    /**
     * 构造方法，初始化成员变量
     * @param v 一个顶点
     * @param w 另一个顶点
     * @param weight 该边的权重
     */
    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重值
     * @return 权重
     */
    public double getWeight(){
        return weight;
    }

    /**
     * 获取边上的一个顶点
     * @return 一个顶点
     */
    public int one(){
        return v;
    }

    /**
     * 获取边上另一个顶点
     * @param curr 当前顶点
     * @return 另一个顶点
     */
    public int theOther(int curr){
        if (curr == v){
            return w;
        }else{
            return v;
        }
    }

    @Override
    public int compareTo(@NotNull Edge o) {
        //设置一个变量标识判断结果
        return Double.compare(this.weight, o.weight);
    }
}
