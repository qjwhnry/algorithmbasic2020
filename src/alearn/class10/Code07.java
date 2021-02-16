package alearn.class10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 三个id相同
 * 头条ID
 * B站ID
 * githubID
 * 要求：只要有一个相同，就属于同一个人
 * 并查集 求解
 */
public class Code07 {


    public static class Node<V> {
        public V v;

        public Node(V v) {
            this.v = v;
        }
    }

    public static class UnionSet<V> {

        HashMap<V, Node<V>> nodes;
        HashMap<Node<V>, Node<V>> parent;
        HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> list) {
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

        public Node getParent(Node<V> cur) {
            if (cur == null) {
                return null;
            }
            Stack<Node<V>> stack = new Stack<>();

            while (null != parent.get(cur)) {
                cur = parent.get(cur);
                stack.push(cur);
            }

            //复杂度
            while (!stack.isEmpty()) {
                parent.put(stack.pop(), cur);
            }
            return cur;
        }

        public void union(V a, V b) {

            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }

            Node parentA = getParent(nodes.get(a));
            Node parentB = getParent(nodes.get(b));
            if (parentA != parentB) {
                Integer integerA = sizeMap.get(parentA);
                Integer integerB = sizeMap.get(parentB);

                Node big = integerA > integerB ? parentA : parentB;
                Node sml = integerA > integerB ? parentB : parentA;
                parent.put(sml, big);
                sizeMap.put(big, integerA + integerB);
                sizeMap.remove(sml);

            }
        }

        public int getSize() {
            return sizeMap.size();
        }

    }


    public static class User{
        String aID;
        String bID;
        String cID;

        public User(String a, String b, String c) {

            aID = a;
            bID = b;
            cID = c;
        }

    }

    public Integer mergeUser(List<User> list) {
        UnionSet<User> set = new UnionSet<>(list);

        HashMap<String, User> mapA = new HashMap<>();
        HashMap<String, User> mapB = new HashMap<>();
        HashMap<String, User> mapC = new HashMap<>();

        for (User user : list) {

            if (mapA.containsKey(user.aID)) {
                set.union(user, mapA.get(user.aID));
            } else {
                mapA.put(user.aID, user);
            }

            if (mapB.containsKey(user.bID)) {
                set.union(user, mapB.get(user.bID));
            } else {
                mapB.put(user.bID, user);
            }

            if (mapC.containsKey(user.cID)) {
                set.union(user, mapC.get(user.cID));
            } else {
                mapC.put(user.cID, user);
            }
        }
        return set.getSize();
    }


}
