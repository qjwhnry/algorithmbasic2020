package alearn.class02_03;

public class Code08 {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 7, 2, 1};
        test(arr);
    }
    public static void test(int[] arr) {

        System.out.println(helper(arr, 0, arr.length - 1));

    }

    private static int helper(int[] arr, int l, int r) {

        if (l >= r) {
            return Math.max(arr[l], arr[r]);
        }
        int mid = l + ((r - l) >> 1);
        int lMax = helper(arr, l, mid);
        int rMax = helper(arr, mid + 1, r);
        return Math.max(lMax, rMax);
    }
}
