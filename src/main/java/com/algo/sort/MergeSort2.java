package com.algo.sort;


import java.util.Arrays;

public class MergeSort2 {

    public static void mergeSort(int[] a, int n) {

        mergeSortInternally(a, 0, n-1);
    }


    //递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {

        //递归终止条件
        if (p >= r) {
            return;
        }
        //取 p到r 之间的中间值。防止 (r+p)/2 大于 int 的最大值
        int q = p + (r - p) / 2;

        //分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        //将 A[p....q] 和 A[q+1...r]合并成 A[p,r]
        mergeBySentry(a, p, q, r);

    }

    /**
     * 通过哨兵来进行合并
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {

        // leftArr.length + rightArr.length = q-p+2+r-q+1 = r - p + 3;
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }

        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }

        rightArr[r - q] = Integer.MAX_VALUE;


        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
