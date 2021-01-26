package alearn.class01_01;

import java.util.Arrays;

public class Code05_2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 7};
        System.out.println(new Code05_2().test(arr, 7));
        System.out.println(Arrays.toString(arr));
    }

    public int test(int[] arr, int num) {
        int index = -1;
        if (arr == null || arr.length == 0) {
            return index;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l < r) {

            int mid = l + ((r - l) >> 1);
            if (arr[mid] <= num) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;


    }
}
