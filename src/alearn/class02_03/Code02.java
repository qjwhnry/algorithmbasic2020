package alearn.class02_03;

/**
 * 删除链表种的节点
 */
public class Code02 {

    public static class Node{
        public int value;
        public Node next;

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


    public void test(Node node,int num) {

        if (node == null) {
            return;
        }

        Node pre = node;
        Node curr = node;
        while (curr != null) {
            if (curr.value == num) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        System.out.println(node);
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new Code02().test(node,2);



    }

}
