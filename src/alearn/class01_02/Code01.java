package alearn.class01_02;

/**
 * 位运算交换数组种的两个位置
 * 相同地址的不能交换，不满足
 * 相同值的可以交换，满足
 */
public class Code01 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 4, 5, 4, 7};

        arr[2] = arr[2] ^ arr[2];
        arr[2] = arr[2] ^ arr[2];
        arr[2] = arr[2] ^ arr[2];
        System.out.println(arr[2]);

    }
}
