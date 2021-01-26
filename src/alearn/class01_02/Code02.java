package alearn.class01_02;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 位运算，偶数，奇数，一个奇数，两个奇数
 */
public class Code02 {

    public static void main(String[] args) {
        //int[] arr = new int[]{3, 3, 5, 7,6, 6};
        //int[] arr = new int[]{3, 3, 5, 13,6, 6};
        int[] arr = new int[]{1, 1, 3, 13,6, 6};
        new Code02().num1(arr);
        new Code02().num2(arr);

        LinkedBlockingQueue<Integer> list = new LinkedBlockingQueue<>(2);
        list.add(1);
        list.add(1);
        list.add(1);
    }

    public void num1(int[] arr) {

        if (arr == null || arr.length == 0) {

            return;
        }

        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            num ^= arr[i];
        }
        System.out.println(num);
    }

    public void num2(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        //先a,b两个亦或
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        //去最后一位1
        // -eor = ~eor+1   取反+1
        int rightOne = eor & (-eor);
        //int rightOne = eor & (~eor+1);

        int one = 0;
        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & rightOne) != 0) {
                one ^= arr[i];
            }
        }
        System.out.println("第一个：" + one + "   " + "第二个：" + (one ^ eor));
    }
}
