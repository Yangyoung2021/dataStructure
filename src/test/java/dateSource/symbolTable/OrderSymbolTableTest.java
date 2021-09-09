package dateSource.symbolTable;

import itHeima.symble.OrderSymbolTable;
import itHeima.symble.SymbolTable;

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        //创建符号表对象
        OrderSymbolTable<Integer,String> symbolTable = new OrderSymbolTable<>();
        //测试put方法
        symbolTable.put(1,"乔峰");
        symbolTable.put(2,"虚竹");
        symbolTable.put(3,"段誉");
        symbolTable.put(6,"海绵宝宝");
        symbolTable.put(9,"派大星");
        symbolTable.put(4,"章鱼哥");
        symbolTable.put(0,"...");

        System.out.println("插入完毕后元素个数为：" + symbolTable.size());

        String s2 = symbolTable.get(2);
        System.out.println("插入完毕前拿到的值为：" + s2);

        symbolTable.put(2,"杨过");
        System.out.println("替换完毕后元素个数为：" + symbolTable.size());
        //测试get方法
        String s = symbolTable.get(2);
        System.out.println("替换完毕后拿到的值为：" + s);
        //测试remove方法
        symbolTable.remove(0);
        System.out.println("移除完毕后元素个数为：" + symbolTable.size());
    }
}
