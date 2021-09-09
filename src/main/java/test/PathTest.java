package test;

import itHeima.graph.DepthFirstPaths;
import itHeima.graph.Graph;
import itHeima.linear.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PathTest {
    public static void main(String[] args) throws Exception {
        final int TARGET = 9;
        final String ERROR = "顶点"+TARGET+"与起点未连接！";
        //构建读取流
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test2.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
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
        //创建路径对象
        DepthFirstPaths dfp = new DepthFirstPaths(g, 0);
        Stack<Integer> targetStack = dfp.pathTo(TARGET);
        if (targetStack == null){
            System.out.println(ERROR);
        }else {
            System.out.println("从0处到"+TARGET+"的路径为：");
            while(!targetStack.isEmpty()){
                System.out.print(targetStack.pop() + "-->");
            }
        }
    }
}
