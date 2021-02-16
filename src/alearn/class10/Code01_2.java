package alearn.class10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 *
 *
 * 三个id相同
 * 头条ID
 * B站ID
 * githubID
 * 要求：只要有一个相同，就属于同一个人
 * 并查集 求解
 */
public class Code01_2 {

    /**
     * 定义数据结构
     * @param <V>
     */
    public static class Node<V>{

        V value;
        public Node(V value){
            this.value = value;
        }
    }

    /**
     * 集合的数据结构
     * @param <V>
     */
    public static class UnionSet<V> {

        HashMap<V, Node<V>> nodes;
        HashMap<Node<V>, Node<V>> parent;
        HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> list){
            nodes = new HashMap<>();
            parent = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V v : list) {
                Node<V> node = new Node<>(v);
                nodes.put(v, node);
                parent.put(node, node);
                sizeMap.put(node, 1);

            }
        }

        /**
         * 得到父节点
         * @param v
         * @return
         */
        public Node<V> getParent(Node<V> cur) {

//            Node<V> cur = nodes.get(v);
            if (cur == null) {
                return null;
            }

            Stack<Node<V>> stack = new Stack<>();
            //找到顶级父级
            while (null != parent.get(cur)) {
                cur = parent.get(cur);
                stack.push(cur);

            }

            //是复杂度变为1，只有一级的话就可以只查询一次
            while (!stack.isEmpty()) {
                parent.put(stack.pop(), cur);
            }

            return cur;

        }


        /**
         * 判断两个节点是否相同的父节点
         * @param a
         * @param b
         * @return
         */
        public boolean isSameNode(V a, V b) {

            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }

            Node<V> parentA = getParent(nodes.get(a));
            Node<V> parentB = getParent(nodes.get(b));
            return parentA == parentB;
        }


        /**
         * 合并两个节点
         *
         * @param node1
         * @param node2
         */
        public void Union(V a, V b) {

            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> parentA = getParent(nodes.get(a));
            Node<V> parentB = getParent(nodes.get(b));
            //不相同的时候才要合并
            if (parentA != parentB) {
                Integer integerA = sizeMap.get(parentA);
                Integer integerB = sizeMap.get(parentB);
                Node<V> big = integerA > integerB ? parentA : parentB;
                Node<V> small = integerA > integerB ? parentB : parentA;
                parent.put(small, big);
                sizeMap.put(big, integerA + integerB);
                sizeMap.remove(small);
            }
        }

    }




}
