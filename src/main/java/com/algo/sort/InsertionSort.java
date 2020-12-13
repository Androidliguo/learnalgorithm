package com.algo.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        //从小到大排序
        for (int i = 1; i < n; i++) {

            //待比较的value
            int value = a[i];
            //有序部分元素的结束位置
            int j = i - 1;

            for (; j >= 0; j--) {
                //从有序部分元素的结束位置开始
                //如果a[j] > 待比较的value
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }

            a[j+1] = value;
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        insertionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }


}
