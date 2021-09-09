package itHeima.uf;

/**
 * 并查集
 */
public class UF {
    //记录节点元素和该元素所在的分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据分组的个数
    private int count;

    //初始化并查集
    public UF(int N){
        //初始化创建N个分组
        this.count = N;
        //初始化数组eleAndGroup（并非存放数据的数组，而是存放每个数组的分组标识的数组）
        this.eleAndGroup = new int[N];
        //将该数组初始化，让标识符等于数组索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }
    //获取当前并查集中分组个数
    public int count(){
        return count;
    }
    //获取p所在的分组的标识符
    public int find(int p){
        return eleAndGroup[p];
    }
    //判断并查集中的p，q元素是否在同一个分组
    public boolean connected(int p, int q){
        return eleAndGroup[p] == eleAndGroup[q];
    }
    //合并p元素和q元素所在的分组
    public void union(int changed, int target){
        //判断changed和target是否是在同一分组，若是直接返回即可
        if (find(changed) == find(target)) return;
        //获取changed元素所在的组标识符
        int changedGroup = find(changed);
        //获取target元素所在的组标识符
        int targetGroup = find(target);
        //将changedGroup所在元素标识符全部改为target所在元素的标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == changedGroup){
                eleAndGroup[i] = targetGroup;
            }
        }
        //分组个数减一
        this.count--;
    }
}
