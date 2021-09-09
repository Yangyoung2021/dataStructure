package test;


import itHeima.graph.DirectedGraph;
import itHeima.graph.TopologySort;
import itHeima.linear.Stack;

public class TopologyCircleTest {
    public static void main(String[] args) {
        DirectedGraph dg = new DirectedGraph(6);
        dg.addEdge(0,2);
        dg.addEdge(0,3);
        dg.addEdge(2,4);
        dg.addEdge(3,4);
        dg.addEdge(4,5);
        dg.addEdge(1,3);
        TopologySort ts = new TopologySort(dg);
        System.out.println(ts.isCircle());
        Stack<Integer> order = ts.getOrder();
        StringBuilder sb = new StringBuilder();
        while(!order.isEmpty()){
            sb.append(order.pop()).append("->");
//            System.out.print(order.pop() + "-->");
        }
        String str = sb.toString();
        int last = str.lastIndexOf("->");
        System.out.println(str.substring(0, last));
    }
}
