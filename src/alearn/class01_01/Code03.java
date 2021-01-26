package alearn.class01_01;

import java.util.Arrays;

public class Code03 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 1, 6, 7};
        new Code03().test(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void test(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
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
