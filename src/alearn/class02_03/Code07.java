package alearn.class02_03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 */
public class Code07 {

    public static class MyStack{

        Queue<Integer> queueDate;
        Queue<Integer> queueHelp;

        public MyStack() {
            queueDate = new LinkedList<>();
            queueHelp = new LinkedList<>();
        }

        public void add(int num) {

            queueDate.add(num);

        }

        public Integer pop() {

            while (queueDate.size() > 1) {
                queueHelp.add(queueDate.poll());
            }
            Integer poll = queueDate.poll();
            Queue<Integer> queueDateT = queueDate;
            queueDate = queueHelp;
            queueHelp = queueDateT;
            return poll;
        }

        public boolean isEmpty() {
            return queueDate.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
