package test;

import itHeima.graph.DepthFirstCircle;
import itHeima.graph.DirectedGraph;

public class CircleTest {
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,5);
        g.addEdge(5,3);
        g.addEdge(3,2);
        g.addEdge(3,4);
        g.addEdge(4,5);
        DepthFirstCircle dfc = new DepthFirstCircle(g);
        boolean flag = dfc.hasCircle();
        System.out.println(flag);
    }
}
