package dateSource.symbolTable;

import itHeima.symble.SymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        //创建符号表对象
        SymbolTable<Integer,String> symbolTable = new SymbolTable<>();
        //测试put方法
        symbolTable.put(1,"乔峰");
        symbolTable.put(2,"虚竹");
        symbolTable.put(3,"段誉");

        System.out.println("插入完毕后元素个数为：" + symbolTable.size());
        symbolTable.put(2,"杨过");
        System.out.println("替换完毕后元素个数为：" + symbolTable.size());
        //测试get方法
        String s2 = symbolTable.get(2);
        System.out.println("拿到的值为：" + s2);
        //测试remove方法
        symbolTable.remove(1);
        System.out.println("移除完毕后元素个数为：" + symbolTable.size());
    }


}
