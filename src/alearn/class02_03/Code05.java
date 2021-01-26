package alearn.class02_03;

import java.util.Stack;

/**
 * 去对应栈中的最小值
 * 使用两个站
 */
public class Code05 {

    public static class MyStack{

        Stack<Integer> stackDate = new Stack<>();
        Stack<Integer> stackMin = new Stack<>();

        public MyStack(){

        }

        public void push(int num) {
            if (stackDate.isEmpty()) {
                stackDate.push(num);
                stackMin.push(num);
                return;
            }
            stackDate.push(num);
            Integer peek = stackMin.peek();
            if (peek > num) {
                stackMin.push(num);
            } else {
                stackMin.push(peek);
            }
        }

        public Integer pop() {
            if (stackDate.isEmpty()) {
                return null;
            }
            stackMin.pop();
            return stackDate.pop();
        }

        public Integer getMid() {
            if (stackMin.isEmpty()) {
                return null;
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(2);
        myStack.push(3);
        myStack.push(1);


        System.out.println(myStack.getMid());
        myStack.pop();
        System.out.println(myStack.getMid());

    }
}
