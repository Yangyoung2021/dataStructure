package dateSource.linear;

import itHeima.linear.LinkList;
import itHeima.linear.Stack;
import org.junit.jupiter.api.Test;
import itHeima.linear.Stack;

public class TestStack {

    @Test
    public void testStack(){
        Stack<String> stack = new Stack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        stack.push("ddd");
        stack.push("eee");
        stack.push("fff");
        for (String s : stack) {
            System.out.println(s);
        }

        String result = stack.pop();
        System.out.println("弹出的元素是：" + result);
        System.out.println("剩余的元素个数是：" + stack.size());

    }

    @Test
    public void testStackReverse(){
        LinkList<String> list = new LinkList<>();
        list.insert("aaa");
        list.insert("bbb");
        list.insert("ccc");
        list.insert("ddd");
        list.insert("eee");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------");

        list.reverse();

        for (String s : list) {
            System.out.println(s);
        }

    }

    @Test
    public void testMatch(){
        String testStr = "(明天你好！)()";
        boolean result = test(testStr);
        System.out.println("匹配结果：" + result);
    }

    private boolean test(String testStr) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < testStr.length(); i++) {
            String str = testStr.charAt(i)+"";
            if (str.equals("(")){
                stack.push(str);
            }else if (str.equals(")")){
                String result = stack.pop();
                //判断弹栈的是否是空
                if (result == null){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
