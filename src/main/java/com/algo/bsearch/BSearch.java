package com.algo.bsearch;

/**
 * @author Legal
 * @date 2021/1/16
 * 二分查找局限性
 * 1. 二分查找依赖的是顺序表结构，也就是数组
 * 2. 二分查找针对的是有序数据
 * 3. 二分查找不适合数据量太大或者太小的
 */
public class BSearch {

    /**
     * 最简单的二分查找算法
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return  mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 修改了mid = low + (high - low) >> 1;
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch2(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            //由于low + high 可能会溢出，因此这样处理
            int mid = low + (high - low) >> 1;
            if (a[mid] == value) {
                return  mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    /**
     * 递归实现
     * @param a
     * @param n
     * @param val
     * @return
     */
    public static int bsearch3(int[] a, int n, int val) {
        return bsearchInterally(a, 0, n - 1, val);
    }


    /**
     * 递归实现的二分查找
     * @param a
     * @param low
     * @param high
     * @param value
     * @return
     */
    private static int bsearchInterally(int[] a, int low, int high, int value) {

        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInterally(a, mid + 1, high, value);
        } else {
            return bsearchInterally(a, low, mid - 1, value);
        }


    }
}
