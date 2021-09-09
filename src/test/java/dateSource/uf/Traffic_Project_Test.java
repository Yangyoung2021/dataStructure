package dateSource.uf;

import itHeima.graph.DepthFirst;
import itHeima.graph.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Traffic_Project_Test {
    public static void main(String[] args) throws Exception {
        //构建读取流
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        //获取顶点数
        int totalNum = Integer.parseInt(br.readLine());
        //构建图对象
        Graph g = new Graph(totalNum);
        //获取总记录条数
        int recordNum = Integer.parseInt(br.readLine());
        //遍历记录
        for (int i = 0; i < recordNum; i++) {
            //获取一行内容
            String s = br.readLine();
            //将内容转换成数组
            String[] str = s.split(" ");
            //将String转换成Integer并加入图中
            g.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        //构建深度优先对象
        DepthFirst depthFirst = new DepthFirst(g, 9);
        //获取结果
        System.out.println("城市8与目标城市是否相通：" + depthFirst.marked(8));
        System.out.println("城市10与目标城市是否相通：" + depthFirst.marked(10));
    }
}
