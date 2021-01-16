package com.algo.bsearch;

/**
 * @author Legal
 * @date 2021/1/16
 * 二分查找的应用
 */
public class BSearchAct {

    /**
     * 查找第一个值等于给定值的元素
     * a[mid] > value : high = mid-1;
     * a[mid] < value : low = mid + 1;
     * a[mid] = value : 判断mid = 0 或 a[mid -1] != value
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchForFirstEqual(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {

            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;

    }


    /**
     * 查找最后一个值等于给定值的元素
     * a[mid] > value : high = mid-1;
     * a[mid] < value : low = mid + 1;
     * a[mid] = value : 判断mid = n-1 或 a[mid+1] != value
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchForLastEqual(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {

            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;

    }


    /**
     * 查找第一个大于等于给定值的元素
     * a[mid] >= value : 判断mid == 0 或 a[mid - 1] < value
     * a[mid] < value : low = mid + 1;
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchForFirstNotLessThan(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {

            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }


    /**
     * 查找第一个小于等于给定值的元素
     * a[mid] >= value : 判断mid == 0 或 a[mid - 1] < value
     * a[mid] < value : low = mid + 1;
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchForLastNotGreaterThan(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {

            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;

    }
}
