package dateSource.graph;

import itHeima.graph.DepthFirst;
import itHeima.graph.Graph;

public class TestDepthFirst {
    public static void main(String[] args) {
        //准备图对象
        Graph graph = new Graph(13);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,5);
        graph.addEdge(0,6);
        graph.addEdge(4,6);
        graph.addEdge(4,3);
        graph.addEdge(4,5);
        graph.addEdge(3,5);
        //准备深度优先对象
        DepthFirst depthFirst = new DepthFirst(graph, 0);
        //测试某个顶点是否与起点相通
        int count = depthFirst.count();
        System.out.println(count);
        System.out.println("----");
        System.out.println(depthFirst.marked(3));
    }
}
