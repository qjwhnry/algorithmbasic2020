package alearn.class02_03;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class Code06 {

    public static class MyQueue{

        Stack<Integer> stackPush;
        Stack<Integer> stackPop;

        public MyQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
        public void add(int num) {
            stackPush.push(num);
            pushToPop();
        }

        public Integer pop() {
            pushToPop();
            if (stackPop.isEmpty()) {
                return null;
            }
            return stackPop.pop();
        }

        public Integer peek() {
            pushToPop();
            if (stackPop.isEmpty()) {
                return null;
            }
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}
