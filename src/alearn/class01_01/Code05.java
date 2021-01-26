package alearn.class01_01;

import java.util.Arrays;

public class Code05 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 7};
        System.out.println(new Code05().test(arr, 2));
        System.out.println(Arrays.toString(arr));
    }

    public int test(int[] arr, int num) {
        int lnum = -1;
        if (arr == null || arr.length == 0) {
            return lnum;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > num) {
                lnum = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return lnum;

    }
}
