package suanfa.type4stack.s3poland;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: Poland
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 20:32
 */
public class Poland {
    public static void main(String[] args) {
        //定义逆波兰表达式
        //1 +（3+4）× 5 - 6 => 3 4 + 5 × 6 -
        //(5 × 6) - 3 + 60 + 3 / 1 => 5 6 × 3 - 60 + 3 1 / +
//        String str1 = "3 4 + 5 × 6 - 1 +";///后缀表达式
//        String str = "5 6 × 3 - 60 + 3 1 / + ";///后缀表达式

        //1、中缀表达式 1+((2+3)*4)-5 => 1 2 3 + 4 * + 5 -
        //2、将"1+((2+3)*4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3、中缀ArrayList[1,+,(,(,2,+,3,),*,4,),-,5] => 后缀ArrayList [1,2,3,+,4,*,+,5,-]
        String s = "1+((2+3)*4)-5";
        System.out.println("原式:"+s);
        //将原始转化为中缀表达式列表
        System.out.print("将原始转化为中缀表达式列表:");
        List<String> list = getInfixExpressionList(s);
        list.forEach(i-> System.out.print(i+'\t'));

        System.out.println();
        //将中缀表达式列表转化为后缀表达式列表
        System.out.print("将上面转化为后缀表达式列表:");
        List<String> list1 = parseSuffixExpressionList(list);
        list1.forEach(i-> System.out.print(i+'\t'));

        System.out.println();
        //结果
        int calculate = calculation(list1);
        System.out.println("运算结果为"+calculate);

    }
    //传入一个中缀表达式字符串  返回一个 数组 中缀表达式[1,+,(,(,2,+,3,),*,4,),-,5]
    public static List<String> getInfixExpressionList(String s){
        List<String> list = new ArrayList<>();
        int i = 0;//索引  辅助指针 用于遍历 s 字符串
        String str;
        char c;
        do {
            //非数字 直接加入  '0' = 48   '1' = 49  '9' = 57
            if((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
                list.add(""+c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c=s.charAt(i)) > 48 && (c=s.charAt(i)) < 57){
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i<s.length());
        return list;
    }
    //传入一个中缀表达式数组 解析成后缀表达式数组
    public static List<String> parseSuffixExpressionList(List<String> list){
        Stack<String> s1 = new Stack<>();//存放运算符
        List<String> s2 = new ArrayList<>();//存结果
        //遍历
        for (String item : list){
            //如果是一个是  直接入栈
            if(item.matches("\\d+")){
                s2.add(item);
            } else if (item.equals("(")){
                s1.push(item);
            } else if (item.equals(")")){
                while (!s1.peek().equals("(")){//查看栈顶 的值 如果不是"(" 则弹出  是就退出循环
                    s2.add(s1.pop());
                }
                s1.pop();//退出循环后 将 "(" 弹出
            } else {
                //只要 栈不为空 且 item运算符的优先级 小于等于于 栈顶运算符的优先级  就运行改操作
                if(s1.size() != 0 && getLevel(item) <= getLevel(s1.peek())){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将 s1符号栈 全部放入 s2中
        while (s1.size() != 0)
            s2.add(s1.pop());
        return s2;
    }
    //获取优先级
    public static int getLevel(String val){
        int res = 0;
        switch (val){
            case "+":
                res = 1;
                break;
            case "-":
                res = 1;
                break;
            case "*":
                res = 2;
                break;
            case "/":
                res = 2;
                break;
            default:
                return res;
        }
        return res;
    }
    /**
     * 传入后缀 表达式数组 进行计算  返回一个具体的数
     * @param ls 传入[5, 6, ×, 3, -, 60, +, 3, 1, /, +]这样的数组
     * @return
     */
    public static int calculation(List<String> ls){
        Stack<String> stack = new Stack<>();

        for (String item : ls){
            if (item.matches("\\d+")){//匹配的是多位数
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                } else if (item.equals("-")){
                    res = num2 - num1;
                } else if (item.equals("/")){
                    res =  num2 / num1;
                } else if (item.equals("*")){
                    res = num1 * num2;
                }else {
                    throw new RuntimeException("运算符错误");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
