package dateSource.graph;

import itHeima.graph.Graph;
import itHeima.graph.WidthFirst;

public class TestWidthFirst {
    public static void main(String[] args) {
        //准备图对象
        Graph graph = new Graph(10);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,5);
        graph.addEdge(0,6);
        graph.addEdge(4,6);
        graph.addEdge(4,3);
        graph.addEdge(4,5);
        graph.addEdge(3,5);
        graph.addEdge(8,9);
        graph.addEdge(7,7);
        //准备深度优先对象
        WidthFirst depthFirst = new WidthFirst(graph, 8);
        //测试某个顶点是否与起点相通
        int count = depthFirst.count();
        System.out.println(count);
        System.out.println("----");
        System.out.println(depthFirst.marked(6));
        System.out.println(depthFirst.marked(8));
        System.out.println(depthFirst.marked(7));
    }
}
