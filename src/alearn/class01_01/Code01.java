package alearn.class01_01;

import java.util.Arrays;

/**
 * 选择
 */
public class Code01 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2, 4, 7, 6};
        selectionSort(arr);
    }
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
