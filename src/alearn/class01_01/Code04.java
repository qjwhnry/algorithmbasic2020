package alearn.class01_01;

import java.util.Arrays;

public class Code04 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 7};
        System.out.println(new Code04().test(arr, 7));
        System.out.println(Arrays.toString(arr));
    }

    public boolean test(int[] arr, int num) {

        if (arr == null || arr.length == 0) {
            return false;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l < r) {

            int mid = (l + r) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] == num;


    }
}
