package alearn.class03_04;

/**
 * 最小和
 */
public class Code02 {

    public static void main(String[] args) {
        //int[] arr = new int[]{1, 3, 4, 6, 5, 2, 7};
        int[] arr = new int[]{1, 3, 6, 4};
        System.out.println(new Code02().test(arr));

    }
    public int  test(int[] arr) {
        return helper(arr, 0, arr.length - 1);

    }

    public int helper(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return helper(arr, l, mid)+
        helper(arr, mid + 1, r)+
        merge(arr, l, mid, r);
    }

    public int merge(int[] arr, int l, int m, int r) {

        int[] helper = new int[r - l + 1];
        int i = 0;
        int l1 = l;
        int l2 = m + 1;
        int res = 0;
        while (l1 <= m && l2 <= r) {

            res += arr[l1] < arr[l2] ? (r - l2 + 1) * arr[l1] : 0;
            helper[i++] = arr[l1] < arr[l2] ? arr[l1++] : arr[l2++];
        }
        while (l1 <= m) {
            helper[i++] = arr[l1++];
        }
        while (l2 <= r) {
            helper[i++] = arr[l2++];
        }

        for (int j = 0; j < helper.length; j++) {
            //arr[l++] = helper[j];
            arr[l + j] = helper[j];
        }
        return res;

    }


}
