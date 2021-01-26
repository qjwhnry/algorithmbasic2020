package alearn.class02_03;

/**
 * 单链表和双链表的反转
 */
public class Code01 {

    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode pre;

        public DoubleNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "DoubleNode{" +
                    "value=" + value +
                    ", next=" + next +
                    ", pre=" + pre +
                    '}';
        }
    }


    public void test(Node node) {

        if (node == null) {
            return;
        }

        Node curr = node;
        Node pre;
        Node res = null;
        while (curr != null) {
            pre = curr.next;
            curr.next = res;
            res = curr;
            curr = pre;
        }
        System.out.println(res);
    }

    public void doubleTest(DoubleNode node) {

        if (node == null) {
            return;
        }

        DoubleNode curr = node;
        DoubleNode pre;
        DoubleNode res = null;
        while (curr != null) {
            pre = curr.next;
            curr.next = res;
            curr.pre = pre;
            res = curr;
            curr = pre;
        }
        while (res != null) {

            System.out.print(res.value +"   ");
            if (res.pre != null) {
                System.out.print(res.pre.value+"   ");
            }
            System.out.println();
            res = res.next;
        }
        //System.out.println(11);
        //System.out.println(res);
    }


    public static void main(String[] args) {
        //Node node = new Node(1);
        //Node node2 = new Node(2);
        //Node node3 = new Node(3);
        //Node node4 = new Node(4);
        //Node node5 = new Node(5);
        //node.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;
        //new Code01().test(node);


        DoubleNode dnode = new DoubleNode(1);
        DoubleNode dnode2 = new DoubleNode(2);
        DoubleNode dnode3 = new DoubleNode(3);
        DoubleNode dnode4 = new DoubleNode(4);
        DoubleNode dnode5 = new DoubleNode(5);
        dnode.next =  dnode2;
        dnode2.pre =  dnode;

        dnode2.next = dnode3;
        dnode3.pre =  dnode2;

        dnode3.next = dnode4;
        dnode4.pre =  dnode3;

        dnode4.next = dnode5;
        dnode5.pre =  dnode4;

        new Code01().doubleTest(dnode);

    }
}
