package com.algo.sort;

import java.util.Arrays;

public class MergeSort {

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
        merge(a, p, q, r);

    }


    //合并
    private static void merge(int[] a, int p, int q, int r) {

        //指向前半部分数组的第一个元素
        int i = p;
        //指向后半部分数组的第一个元素
        int j = q + 1;
        // 初始化变量 k =0;
        int k = 0;

        //申请一个和数组a长度一样的临时数组
        int[] tmp = new int[r - p + 1];

        //双指针算法。将较小的元素放入到临时数组中，并且指针进行移动
        while (i <= q && j <= r) {

            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }

        }


        //将剩余的数据拷贝到临时数组tmp中
        int start = i;
        int end = q;

        //注意 j++, 这个可能会导致 j > r; 也就是后半部分的数组都已经加入到临时数组中了
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }


        //拷贝，临时数组中的内容拷贝到原数组中
        for (i = 0; i <= r - p; ++i) {
            a[p+i] = tmp[i];
        }



    }

    public static void main(String[] args) {

        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
