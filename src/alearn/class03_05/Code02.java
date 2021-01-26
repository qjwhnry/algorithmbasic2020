package alearn.class03_05;

import java.util.Arrays;

public class Code02 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 13, 7, 4, 5, 9, 11, 10};

        new Code02().test(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void test(int[] arr) {

        helper(arr, 0, arr.length - 1);
    }

    public void helper(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = process(arr, l, r);
        System.out.println(mid);
        //helper(arr, l, mid);
        helper(arr, l, mid - 1);
        helper(arr, mid + 1, r);

    }

    public int process(int[] arr, int l, int r) {
        //if (l > r) {
        //    return -1;
        //}
        //if (l == r) {
        //    return l;
        //}
        //以r为基准
        int less = l;
        int index = l;
        while (index < r) {
            //if (arr[index] < arr[r] && less != index) {
            if (arr[index] <= arr[r]) {
                swap(arr, index, less++);
            }
            index++;
        }
        swap(arr, less, r);
        return less;
    }

    public void swap(int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
