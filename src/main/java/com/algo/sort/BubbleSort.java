package com.algo.sort;

import java.util.Arrays;

/**
 * 简单冒泡排序
 *
 */
public class BubbleSort {
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            //提前退出的标志位
            boolean flag = false;

            for (int j = 0; j < n - j - 1; ++j) {
                //交换
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    //此次冒泡有数据交换
                    flag = true;
                }
            }

            //此次冒泡没有数据交换
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
