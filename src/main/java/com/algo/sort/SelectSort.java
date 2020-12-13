package com.algo.sort;

import java.util.Arrays;

public class SelectSort {

    /**
     * 选择排序:每次都从未排序部分的元素选择最小的元素
     * @param a   数组
     * @param n   数组的长度
     */
    public static void selectSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        //只需找到 n-2 就可以了。因为每次都是找出最小的元素，那么剩下的元素就是最大的。
        //无须再进行比较了
        for (int i = 0; i < n - 1; ++i) {
            //查找最小值
            int minIndex = i;

            for (int j = i + 1; j < n; ++j) {

                //找到此次最小的元素的下标
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            //交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;

        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        selectSort(array, array.length);
        System.out.println(Arrays.toString(array));

    }
}
