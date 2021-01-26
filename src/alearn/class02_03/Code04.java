package alearn.class02_03;

/**
 * 数组实现栈和队列
 */
public class Code04 {


    public static class MyQueue{

        int[] arr;
        int size;
        int push;
        int pull;
        int limit;
        public MyQueue(int limit) {
            arr = new int[limit];
            size = 0;
            pull = 0;
            push = 0;
            this.limit = limit;
        }


        public void add(int num) {
            if (size == limit) {
                throw new RuntimeException("队列满了");
            }

            size++;
            arr[push] = num;
            push = getNext(push);
        }

        public Integer pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了");
            }

            size--;
            int res = arr[pull];
            pull = getNext(pull);
            return res;

        }
        public int getNext(int index) {

            return index < limit - 1 ? index + 1 : 0;
        }
    }

    public static class MyStack{

        int[] arr;
        int push;
        int limit;
        public MyStack(int limit) {
            arr = new int[limit];
            push = 0;
            this.limit = limit;
        }


        public void add(int num) {
            if (push == limit) {
                throw new RuntimeException("栈满了");
            }

            arr[push++] = num;
        }

        public Integer pop() {
            if (push == 0) {
                throw new RuntimeException("栈空了");
            }

            return arr[--push];

        }

    }

    public static void main(String[] args) {
        //MyQueue queue = new MyQueue(3);
        //
        //queue.add(1);
        //queue.add(2);
        //queue.add(3);
        //System.out.println(queue.pop());
        //System.out.println(queue.pop());
        //System.out.println(queue.pop());
        //System.out.println(queue.pop());

        MyStack stack = new MyStack(3);

        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
