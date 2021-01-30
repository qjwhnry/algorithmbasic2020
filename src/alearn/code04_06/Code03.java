package alearn.code04_06;

public class Code03 {

    public static class MyHeap{

        private int[] heap;
        private int heapSize;
        private int limit;

        public MyHeap(int limit) {
            this.limit = limit;
        }

        public void heapSort(int[] arr) {

        }





        //从下往上
        public void heapInsert(int[] arr, int length) {

            while (arr[length] > arr[(length - 1) / 2]) {
                swap(arr, length, (length - 1) / 2);
                length = (length - 1) / 2;
            }

        }

        //从上往下
        public void heapfiy(int[] arr, int index, int length) {
            int left = index * 2 + 1;
            while (left < length) {
                int lagest = (left + 1 < length && arr[left + 1] > arr[left]) ? left + 1 : left;
                lagest = arr[index] > arr[lagest] ? index : lagest;
                if (lagest == index) {
                    break;
                }
                swap(arr, lagest, index);
                index = lagest;
                left = lagest * 2 + 1;
            }
        }





        public void swap(int[] arr, int l, int r) {
            int item = arr[l];
            arr[l] = arr[r];
            arr[r] = item;
        }
    }
}
