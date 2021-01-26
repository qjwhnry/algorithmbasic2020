package alearn.class02_03;

/**
 * 链表实现栈和队列
 */
public class Code03 {

    public static class Node{
        int value;
        Node next;
        Node last;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class StackAndQueue{


        Node head = null;
        Node tail = null;


        public void addFromHead(int num) {
            Node node = new Node(num);
            if (head == null || tail == null) {
                head = node;
                tail = node;
                return;
            }
            node.next = head;
            head.last = node;
            head = node;
        }

        public void addFromTail(int num) {

            Node node = new Node(num);
            if (head == null || tail == null) {
                head = node;
                tail = node;
                return;
            }
            node.last = tail;
            tail.next = node;
            tail = node;
        }


        public Integer popFromHead() {
            if (head == null) {
                return null;
            }
            Node pop = head;
            if (head == tail) {
                head = null;
                tail = null;
                return pop.value;
            }
            head = head.next;
            pop.next = null;
            head.last = null;
            return pop.value;
        }

        public Integer popFormTail() {

            if (tail == null) {
                return null;
            }
            Node pop = tail;
            if (tail == head) {
                tail = null;
                head = null;
                return pop.value;
            }
            tail = tail.last;
            tail.next = null;
            pop.last = null;
            //tail = last;
            return pop.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

    }


    public static class MyStack{
        private StackAndQueue stack;
        public MyStack() {
            stack = new StackAndQueue();
        }
        public void add(int num) {
            stack.addFromHead(num);
        }

        public Integer pop() {
            return stack.popFromHead();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static class MyQueue{
        private StackAndQueue queue;

        public MyQueue() {
            queue = new StackAndQueue();
        }

        public void add(int num) {
            queue.addFromHead(num);
        }

        public int pop() {
            return queue.popFormTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }



}
