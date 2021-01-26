package alearn.class01_01;

import java.util.Arrays;

public class Code02 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 1, 6, 7};
        new Code02().test(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void test(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = arr.length-1; i >=0; i--) {

            int maxNum = i;
            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[i]) {
                    maxNum = j;
                    swap(arr, i, j);
                }
            }

        }
    }

    public void swap(int[] arr, int i, int j) {

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
