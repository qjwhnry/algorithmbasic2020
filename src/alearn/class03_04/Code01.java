package alearn.class03_04;

import java.util.Arrays;

/**
 * 是arr数组变为有序
 */
public class Code01 {
    static final int SHARED_SHIFT   = 16;
    static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
    static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    public static void main(String[] args) {

        test11();
        int[] arr = new int[]{1, 3, 7, 4, 5, 9,11,10};
        //new Code01().test(arr);
        new Code01().test2(arr);
    }


    public static void test11() {
        System.out.println(SHARED_UNIT);
        System.out.println(MAX_COUNT);
        System.out.println(EXCLUSIVE_MASK);

    }


    public void test(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        helper(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public void helper(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        helper(arr, l, mid );
        helper(arr, mid + 1, r);
        merge(arr, l, mid, r);


    }


    public void merge(int[] arr, int l, int m, int r) {

        int[] helper = new int[r - l + 1];
        int i = 0;
        int l1 = l;
        int l2 = m+1;
        //1、需要比较等于的时候，因为没有越界，等于才把所有条件比较完
        //2、&& 防止左边或者右边越界
        while (l1 <= m && l2 <= r) {
            helper[i++] = arr[l1] < arr[l2] ? arr[l1++] : arr[l2++];
        }
        //要么第一个越界， 要么第二个越界
        while (l1 <= m) {
            helper[i++] = arr[l1++];
        }
        while (l2 <= r) {
            helper[i++] = arr[l2++];
        }
        //赋值到原来数组上
        for (int j = 0; j < helper.length; j++) {
            arr[l++] = helper[j];
        }

    }

    public void test2(int[] arr) {

        int gap = 1;
        int length = arr.length - 1;

        while (gap < length) {
            int i = 0;
            while (i < length) {
                if (i + gap-1 > length ) {
                    break;
                }
                //int mid = i+((gap-1) / 2);
                int mid = i + gap - 1;
                //最后防止越界
                int right = mid + Math.min(gap, length - mid + 1);
                merge(arr, i, mid, right);

                //merge(arr, i, mid, i + gap-1);
                //i += gap;
                //i = i + gap;
                i = right + 1;
            }
            //防止溢出
            if (gap > length / 2) {
                break;
            }
            gap = gap << 1;
        }

        System.out.println(Arrays.toString(arr));
    }
}
