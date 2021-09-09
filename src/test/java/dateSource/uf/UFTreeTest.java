package dateSource.uf;

import itHeima.uf.UF_Tree;

import java.util.Scanner;

public class UFTreeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入并查集中元素的个数:");
        int N = sc.nextInt();
        UF_Tree uf = new UF_Tree(N);
        while (true) {
            System.out.println("请录入您要合并的第一个点:");

            int p = sc.nextInt();
            System.out.println("请录入您要合并的第二个点:");
            int q = sc.nextInt();
            //判断p和q是否在同一个组
            if (uf.connected(p, q)) {
                System.out.println("结点" + p + "和结点" + q + "已经在同一个组");
                continue;
            }
            uf.union(p, q);
            System.err.println("总共还有" + uf.count() + "个分组");
        }
    }
}

