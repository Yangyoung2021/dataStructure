package itHeima.graph;

import itHeima.linear.Stack;

/**
 * 拓扑排序
 */
public class TopologySort {
    //反转的栈
    private Stack<Integer> order;

    /**
     * 构造方法
     * @param dg 有向图
     */
    public TopologySort(DirectedGraph dg){
        //判断当前节点是否有环
        DepthFirstCircle dfc = new DepthFirstCircle(dg);
        if (!dfc.hasCircle()){
            //不存在环，通过深度排序获取反转栈
            DepthOrder depthOrder = new DepthOrder(dg);
            order = depthOrder.ReversePost();
        }
    }

    /**
     * 判断是否有环
     * @return 判断结果
     */
    public boolean isCircle(){
        return order.isEmpty();
    }

    /**
     * 获取反转栈
     * @return 反转栈
     */
    public Stack<Integer> getOrder(){
        return order;
    }
}
