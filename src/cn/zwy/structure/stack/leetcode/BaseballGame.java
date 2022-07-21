package cn.zwy.structure.stack.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/baseball-game/">棒球比赛</a> <BR/>
 * &#064;author:  zwy <BR/>
 * &#064;date:  2022年07月21日 11:02 <BR/>
 */
public class BaseballGame {


    /**
     * 思路一：栈处理<BR/>
     * 1.如果 ops == “C” 把栈顶的弹出<BR/>
     * 2.如果 ops == “D” 把栈顶的数据×2入栈<BR/>
     * 3.如果 ops == “+” 把栈顶数据弹出 然后 再和 栈顶相加，把弹出的入栈，把结果再入栈<BR/>
     * 4.ops 其他结果直接入栈<BR/>
     *
     * @param ops 数组
     * @return 返回总分
     */
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();
        int ret = 0;

        for (String op : ops) {
            switch (op) {
                case "C":
                    ret-=stack.peek();
                    stack.pop();
                    break;
                case "D":
                    int i = stack.peek() * 2;
                    ret+=i;
                    stack.push(i );
                    break;
                case "+":
                    int tempA;
                    int tempB;
                    tempA = stack.pop();
                    tempB = stack.peek();
                    stack.push(tempA);
                    int i1 = tempA + tempB;
                    ret+= i1;
                    stack.push(i1);
                    break;
                default:
                    Integer integer = new Integer(op);
                    ret+=integer;
                    stack.push(integer);
                    break;
            }
        }

        return ret;
    }

    /**
     * 思路二：集合处理<BR/>
     * 1.如果 ops == “C” 把集合长度的数据的弹出<BR/>
     * 2.如果 ops == “D” 把集合长度的数据×2入栈<BR/>
     * 3.如果 ops == “+” <BR/>
     * 4.ops 其他结果直接入栈<BR/>
     *
     * @param ops 数组
     * @return 返回总分
     */
    public int calPointsList(String[] ops) {
        List<Integer> list = new ArrayList<>();
        int ret = 0;

        for (String op : ops) {
            switch (op) {
                case "C":
                    ret -= (list.size()-1);
                    list.remove(list.size()-1);
                    break;
                case "D":
                    ret+= (list.get((list.size()-1)) * 2);
                    list.add(list.get((list.size()-1)) * 2);
                    break;
                case "+":
                    ret += list.get(list.size()-1)+list.get(list.size()-2);
                    list.add(list.get(list.size()-1)+list.get(list.size()-2));
                    break;
                default:
                    ret += new Integer(op);
                    list.add(new Integer(op));
                    break;
            }
        }

        return ret;
    }
}
