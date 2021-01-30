package alearn.code04_06;

import java.util.*;

/**
 * 创建一个堆，大顶堆
 * 从上往下找：  弹出的时候
 * 和从下往上找：  插入的时候
 */
public class Code02 {


    public static class MaxHeap{

        private int[] heap;
        private int limit;
        private int size;

        public MaxHeap(int limit) {
            this.limit = limit;
            heap = new int[limit];
        }

        public int size(){
            return heap.length;
        }

        public boolean isEmpty(){
            return heap.length==0;
        }


        public void put(int value){
            if (size == limit) {
                throw new RuntimeException("满了");
            }
            heap[size] = value;
            headInsert(heap, size++);
        }

        //返回最大根
        public int pop(){
            if (size == 0) {
                throw new RuntimeException("isEmpty ！");
            }
            int res = heap[0];
            swap(heap, 0, --size);
            heapUp(heap, 0, size);

            return res;
        }


        //往上迭代，父级
        public void headInsert(int[] arr, int length) {
            int curr = length;
            while (arr[curr] > arr[(curr - 1) / 2]) {
                swap(arr, curr, (curr - 1) / 2);
                curr = (curr - 1) / 2;
            }
        }

        //往下迭代
        public void heapUp(int[] arr, int index, int size) {

            int left = index * 2 + 1;
            while (left < size) {

                //比较两个子节点的大小
                int lagest = (left + 1 < size && arr[left] < arr[left + 1]) ? left + 1 : left;

                //int lagest = arr[left] > arr[left + 1] ? left : left + 1;
                lagest = arr[lagest] > arr[index] ? lagest : index;
                //相同，就证明移动到范围内的最底下了
                if (lagest == index) {
                    break;
                }
                swap(arr, lagest, index);
                left = left * 2 + 1;
            }
        }

        public void swap(int[] arr, int l, int r) {

            int item = arr[l];
            arr[l] = arr[r];
            arr[r] = item;
        }


    }


    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComparator());
        priorityQueue.add(2);
        priorityQueue.add(7);
        priorityQueue.add(3);
        priorityQueue.add(4);
        System.out.println(priorityQueue.poll());
        //List<Integer> list = new ArrayList<>();
        //list.add(2);
        //list.add(7);
        //list.add(3);
        //list.add(4);
        //MyComparator comparator = new MyComparator();
        //Arrays.sort(list,comparator);


        //MaxHeap maxHeap = new MaxHeap(5);
        //maxHeap.put(1);
        //maxHeap.put(2);
        //maxHeap.put(6);
        //maxHeap.put(4);
        //maxHeap.put(5);
        //System.out.println(maxHeap.pop());


    }
}
