package itHeima.uf;

import java.util.Arrays;

/**
 * 并查集
 */
public class UF_Tree_Weighted {
    //记录节点元素和该元素所在的分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据分组的个数
    private int count;
    //记录每个分组的元素个数
    private int[] sz;
    //初始化并查集
    public UF_Tree_Weighted(int N){
        //初始化创建N个分组
        this.count = N;
        //初始化数组eleAndGroup（并非存放数据的数组，而是存放每个数组的分组标识的数组）
        this.eleAndGroup = new int[N];
        this.sz = new int[N];
        //将该数组初始化，让标识符等于数组索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        //初始化sz数组
        Arrays.fill(sz, 1);
    }

    //获取当前并查集中分组个数
    public int count(){
        return count;
    }

    //获取p所在的分组的标识符(根节点)
    public int find(int p){
        while(true){
            //当当前元素与当前索引值相同说明这是一个根节点
            if (p == eleAndGroup[p]) return p;
            //如果不是就返回该索引的值
            p = eleAndGroup[p];
        }
    }

    //判断并查集中的p，q元素是否在同一个分组
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    //合并p元素和q元素所在的分组
    public void union(int ele1, int ele2){
        //获取changed元素所在的组标识符
        int group1 = find(ele1);
        //获取target元素所在的组标识符
        int group2 = find(ele2);
        //判断两者是否已经在同一分组
        if (group1 == group2) return;
        //将小树合并到大树上
        if (sz[group2] > sz[group1]){
            eleAndGroup[group1] = group2;
            //重新调整较大树的元素个数
            sz[group2] += sz[group1];
        }else{
            eleAndGroup[group2] = group1;
            //重新调整较大树的元素个数
            sz[group1] += sz[group2];
        }
        //分组个数减一
        this.count--;
    }
}
