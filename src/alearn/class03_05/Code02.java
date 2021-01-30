package alearn.class03_05;

import java.util.Arrays;

public class Code02 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 13, 7, 4, 10,5, 9, 11, 10};

        new Code02().test2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void test1(int[] arr) {

        helper(arr, 0, arr.length - 1);
    }

    public void test2(int[] arr) {

        helper2(arr, 0, arr.length - 1);
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

    public void helper2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] ints = process2(arr, l, r);
        System.out.println(Arrays.toString(ints));
        //helper(arr, l, mid);
        helper2(arr, l, ints[0] - 1);
        helper2(arr, ints[1] + 1, r);

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

    //小于等于大于 arr[l] <= arr[r] >=
    public int[] process2(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1,-1};
        }
        if (l == r) {
            return new int[]{l,l};
        }
        //以r为基准
        int less = l-1;
        int r1 = r;
        int index = l;
        while (index < r1) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                swap(arr, index++, ++less);
            }else {
                System.out.println(r1);
                swap(arr, index, --r1);
            }
        }
        swap(arr, r1, r);
        return new int[]{less, r1};
    }

    public void swap(int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
