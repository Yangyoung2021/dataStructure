package dateSource.linear;

import itHeima.linear.Stack;
import org.junit.jupiter.api.Test;

/**
 * 逆波兰表达式（将运算符放到操作数的后面进行操作）
 */
public class ReversePolishNotationTest {

    @Test
    public void test(){
        //中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        String[] notation = {"3", "20", "15", "-", "*","18", "6","/","+"};
        int result = calculate(notation);
        System.out.println("计算结果是："+result);
    }

    /**
     * 计算所用方法
     * @param notation 要计算的字符串数组
     * @return 逆波兰表达式的计算结果
     */
    private int calculate(String[] notation) {
        /*
        计算逻辑：
            判断当前的字符串内容是运算符还是操作数
                1.如果是操作数就直接压栈
                2.如果是运算符就将前两个数弹栈，进行相对应的计算
            最后弹出的就是运算结果（怎么找到最后一次运算）
         */
        //创建一个栈
        Stack<Integer> operands = new Stack<>();
        for (String curr : notation) {
            switch (curr) {
                case "+":
                    Integer p1 = operands.pop(); //plus
                    Integer p2 = operands.pop();
                    operands.push(p2 + p1);
                    break;
                case "-":
                    Integer s1 = operands.pop(); //subtract
                    Integer s2 = operands.pop();
                    operands.push(s2 - s1);
                    break;
                case "*":
                    Integer m1 = operands.pop(); //multiply
                    Integer m2 = operands.pop();
                    operands.push(m2 * m1);
                    break;
                case "/":
                    Integer d1 = operands.pop(); //divide
                    Integer d2 = operands.pop();
                    operands.push(d2 / d1);
                    break;
                default:
                    operands.push(Integer.parseInt(curr));
                    break;
            }
        }
        return operands.pop();
    }


}
